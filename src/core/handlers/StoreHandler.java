package core.handlers;

import core.GameManager;
import model.Player;
import model.moves.Move;
import utils.StringReader;

import javax.swing.*;

import java.awt.*;
import java.util.Map;

import static resources.GameMenuStrings.getErrorText;
import static resources.OverworldStrings.getOverworldString;
import static resources.StoreStrings.*;

public class StoreHandler {
    private JTextArea display;
    private GameManager gameManager;
    private Player player;
    private StringReader sr;
    private StoreState state;

    /* MOVE CHANGING*/
    Map<String, Move> moveCatalog;
    private Move move; // 0 = attack, 1 = powerup, 2 = weaken
    private int moveType;

    private enum StoreState {
        SHOPPING, CONFIRM
    }

    public StoreHandler(GameManager gameManager, Player player, StringReader sr, JTextArea display) {
        this.display = display;
        this.gameManager = gameManager;
        this.player = player;
        this.sr = sr;
        this.move = null;
        this.moveType = -1;
        state = StoreState.SHOPPING;
        moveCatalog = gameManager.data.moveCatalog;
    }

    public void handleTrainingSelection(String choice) {
        if(state == StoreState.CONFIRM) {
            if(move == null || moveType == -1) { // failsafe
                state = StoreState.SHOPPING;
                System.out.println("Bought move NULL");
                display.setText(getTrainingString(player));
                return;
            }                                                            
            handleConfirm(choice);
        }

        switch (choice) {
            case "1":

                break;
            case "2":
                gameManager.loadScene(getOverworldString());
                gameManager.gameState = GameManager.GameState.OVERWORLD;
                break;
            /* ATTACK */
            case "10":
                changeMove(moveCatalog.get("ROOKIE KICK"), 0);
                break;
            case "11":
                changeMove(moveCatalog.get("PUKE ATTACK"), 0);
                break;
            case "12":
                changeMove(moveCatalog.get("F-SIDEFLIP"), 0);
                break;
            case "13":
                changeMove(moveCatalog.get("ROOKIE RAGE"), 0);
                break;
            case "20":
                changeMove(moveCatalog.get("FLASH TUX"), 1);
                break;
            case "21":
                changeMove(moveCatalog.get("SELL PATCHES"), 1);
                break;
            case "22":
                if(gameManager.player.getRookie().getName() != "EMMA") changeMove(moveCatalog.get("EYBRO"), 1);
                else display.append("\n EMMA can't drink this because\nit contains gluten!");
                break;
            case "23":
                changeMove(moveCatalog.get("PEA SOUP"), 1);
                break;
            case "24":
                changeMove(moveCatalog.get("ROOKIE KICK"), 1);
                break;
            case "25":
                changeMove(moveCatalog.get("PUNSCH"), 1);
                break;
            case "30":
                changeMove(moveCatalog.get("CALCULUS"), 2);
                break;
            case "31":
                changeMove(moveCatalog.get("HUNGOVER"), 2);
                break;
            case "32":
                changeMove(moveCatalog.get("BENDER"), 2);
                break;
            case "33":
                changeMove(moveCatalog.get("TENGIL SITTING"), 2);
                break;
            case "34":
                changeMove(moveCatalog.get("FERNET"), 2);
                break;
            case "35":
                changeMove(moveCatalog.get("DUNKED"), 2);
                break;
            default:
                display.append(getErrorText());
        }
    }

    private void handleStoreSelection(String choice) {
    }

    private void handleConfirm(String choice) {
        switch (choice) {
            case "1":
                confirmedChangeMove();
                break;
            case "2":
                state = StoreState.SHOPPING;
                display.setText(getTrainingString(player));
                break;
            default:
                display.append(getErrorText());
                break;
        }
    }

    private void changeMove(Move move, int moveType) {
        player = gameManager.player;
        if(player.getGold() < move.getCost()) {
            display.append("\n You don't have enough Gold");
            return;
        }
        this.move = move;
        this.moveType = moveType;
        state = StoreState.CONFIRM;
        display.setText(getConfirmText());
    }

    private void confirmedChangeMove() {
        player.setGold(player.getGold() - move.getCost());
        player.getRookie().setMove(move, moveType);
        switch (moveType) {
            case 0:
                display.append("\n ATTACK updated --> " + move.getName());
                break;
            case 1:
                display.append("\n POWERUP updated --> " + move.getName());
                break;
            case 2:
                display.append("\n WEAKEN updated --> " + move.getName());
                break;
        }
        display.append("\n New balance: " + player.getGold());
        gameManager.updatePlayer(player);
        this.move = null;
        this.moveType = -1;
        state = StoreState.SHOPPING;
        gameManager.loadScene(getTrainingString(player));
    }
}

