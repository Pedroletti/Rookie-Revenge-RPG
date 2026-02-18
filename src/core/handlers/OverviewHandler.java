package core.handlers;

import core.GameManager;
import model.Battleground;
import model.Player;

import javax.swing.*;

import static resources.GameMenuStrings.getGameMenuString;
import static resources.GameMenuStrings.getErrorText;

public class OverviewHandler {
    private final JTextArea display;
    private final GameManager gameManager;
    private GameMenuHandler.GameState gameState;
    private Player player;
    private OverviewHandler overviewHandler;

    public enum GameState {
        MENU, BATTLE, IDLE
    }
    public OverviewHandler(GameManager gameManager, Player player, JTextArea display) {
        this.display = display;
        this.gameManager = gameManager;
        this.player = player;
        gameState = GameMenuHandler.GameState.MENU;
    }

    public void handleSelection(String choice) {
        switch (choice) {
            case "1":
                handleBattle(gameManager.data.battlegrounds.get(0));
                break;
            case "2":
                handleBattle(gameManager.data.battlegrounds.get(1));
                break;
            case "10":
                gameManager.gameState = GameManager.GameState.GAME_MENU;
                display.setText(getGameMenuString());
                break;
            default:
                display.append(getErrorText());
                break;
        }
    }
    public void updatePlayer(Player player) {
        this.player = player;
    }

    private void handleBattle(Battleground battleground) {
        if (battleground.isLocked()) {
            display.append("\n Battleground is locked!");
            return;
        }
        if (battleground.isDefeated()) {
            display.append("\n Gym is defeated!");
            return;
        }
        if (battleground.isGym()) gameManager.setEnemy(battleground.getNextOpponent());
        else gameManager.setEnemy(battleground.getRandomOpponent());

        gameManager.setBattleground(battleground);
        gameManager.gameState = GameManager.GameState.BATTLE;
        gameManager.loadBattle(player, gameManager.enemy);

    }
}
