package core.handlers;

import core.GameManager;
import model.Player;
import static resources.GameMenuStrings.*;
import static resources.MainMenuStrings.getMenuString;
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
                display.setText(getOverworldString(gameManager));
                gameManager.gameState = GameManager.GameState.OVERWORLD;
                gameState = GameState.MENU;
                break;
            case "2":
                display.setText(getTeamString(player));
                if(player.isDev()) display.append(player.getDev());
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
            case "dev":
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
                if(gameManager.player.toggleDev()) display.append("\n Dev Mode: Enabled");
                else display.append("\n Dev Mode: Disabled");
                break;
            case "3":
                gameManager.data.buildWorld();
                display.append("\n World reloaded!");
                break;
            case "4":
                gameManager.player.getRookie().setMove(gameManager.storeHandler.moveCatalog.get("GOD KICK"), 0);
                display.append("\n ATTACK updated --> " + gameManager.storeHandler.moveCatalog.get("GOD KICK").getName());
                break;
            case "5":
                gameState = GameState.MENU;
                display.setText(getGameMenuString());
                break;
            default:
                int amount = Integer.parseInt(choice);
                player.addGold(amount);
                display.append("\n You received " + amount + " gold!");
                break;
        }
    }
    public void updatePlayer(Player player) {
        this.player = player;
    }
}
