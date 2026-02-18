package core.handlers;

import core.GameManager;
import model.Player;
import static resources.GameMenuStrings.*;
import static resources.MainMenuHandler.getMenuString;
import static resources.OverworldStrings.getOverworldString;
import javax.swing.*;



public class GameMenuHandler {
    private final JTextArea display;
    private final GameManager gameManager;
    private GameState gameState;
    private Player player;

    public enum GameState {
        MENU, IDLE, DEV
    }


    public GameMenuHandler(GameManager gameManager, Player player, JTextArea display) {
        this.display = display;
        this.gameManager = gameManager;
        this.player = player;
        gameState = GameState.MENU;
    }

    public void handleSelection(String choice) {
        switch (gameState) {
            case MENU:
                handleOverworldSelection(choice);
                break;
            case IDLE:
                handleEscapeSelection(choice);
                break;
            case DEV:
                handleDevChoice(choice);
                break;

        }
    }

    private void handleOverworldSelection(String choice) {
        switch (choice) {
            case "1":
                display.setText(getOverworldString());
                gameManager.gameState = GameManager.GameState.OVERWORLD;
                gameState = GameState.MENU;
                break;
            case "2":
                display.setText(getTeamString(player));
                display.append(getEnterText());
                gameState = GameState.IDLE;
                break;
            case "3":
                display.setText(getInstructionString());
                display.append(getEnterText());
                gameState = GameState.IDLE;
                break;
            case "4":
                if(gameManager.saveGame()) display.append("\n Game saved!");
                else display.append("\n Game not saved!");
                gameState = GameState.MENU;
                break;
            case "6":
                gameManager.loadScene(getMenuString());
                gameManager.gameState = GameManager.GameState.MAIN_MENU;
                break;
            case "1337":
                gameState = GameState.DEV;
                display.setText(getDevString());
                break;
            default:
                display.append(getErrorText());
        }
    }

    private void handleEscapeSelection(String choice) {
        switch (choice) {
            case "0":
                gameState = GameState.MENU;
                display.setText(getGameMenuString());
                break;
            default:
                display.append(getErrorText());
        }
    }

    private void handleDevChoice(String choice) {
        switch (choice) {
            case "1":
                player.getRookie().levelUp(1);
                display.append("\n " + player.getRookie().getName() + " reached level " + player.getRookie().getLevel() + "!");
                break;
            case "2":
                gameState = GameState.MENU;
                display.setText(getGameMenuString());
                break;
            default:
                display.append(getErrorText());
        }
    }
    public void updatePlayer(Player player) {
        this.player = player;
    }
}
