package core.handlers;

import core.GameManager;
import model.Battleground;
import model.Player;
import model.Rookie;
import utils.StringReader;

import javax.swing.*;

import static resources.GameMenuStrings.getGameMenuString;
import static resources.GameMenuStrings.getErrorText;
import static resources.StoreStrings.getIntroTexts;
import static resources.StoreStrings.getTrainingString;

public class OverworldHandler {
    private final JTextArea display;
    private final GameManager gameManager;
    private GameMenuHandler.GameState gameState;
    private Player player;
    private OverworldHandler overviewHandler;
    private StringReader sr;

    public enum GameState {
        MENU, BATTLE, IDLE
    }
    public OverworldHandler(GameManager gameManager, Player player, StringReader sr, JTextArea display) {
        this.display = display;
        this.gameManager = gameManager;
        this.player = player;
        this.sr = sr;
        gameState = GameMenuHandler.GameState.MENU;
    }

    public void handleSelection(String choice) {
        switch (choice) {
            case "1":
                handleBattle(0);
                break;
            case "2":
                handleBattle(1);
                break;
            case "3":
                handleBattle(2);
                break;
            case "4":
                handleBattle(3);
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

    private void handleBattle(int battlegroundId) {
        Battleground battleground = gameManager.data.battlegrounds.get(battlegroundId);
        if (!gameManager.player.isDev()) {
            if (battleground.isLocked()) {
                if (!unlockBattleground(battlegroundId)) {
                    display.append("\n Battleground is locked!");
                    return;
                }
            }
        }
        if (battleground.isDefeated()) {
            if (battleground.isTraining()) {
                gameManager.gameState = GameManager.GameState.TRAINING;
                gameManager.loadScene(getTrainingString(player));
            } else if (battleground.isStore()) {
                gameManager.gameState = GameManager.GameState.STORE;
            } else display.append("\n Gym is defeated!");
            return;
        }

        if (battleground.isGym()) gameManager.setEnemy(battleground.getNextOpponent());
        else gameManager.setEnemy(battleground.getRandomOpponent());

        gameManager.setBattleground(battleground);
        gameManager.gameState = GameManager.GameState.BATTLE;
        gameManager.loadBattle(battleground.isGym());
    }

    private boolean unlockBattleground(int battlegroundId) {
        switch (battlegroundId) {
            case 2:
                if(gameManager.data.battlegrounds.get(1).isDefeated()) {
                    gameManager.data.battlegrounds.get(2).setLocked(false);
                    gameManager.data.battlegrounds.get(3).setLocked(false);
                    return true;
                } else return false;
            case 4:
                if(gameManager.data.battlegrounds.get(3).isDefeated()) {
                    gameManager.data.battlegrounds.get(4).setLocked(false);
                    gameManager.data.battlegrounds.get(5).setLocked(false);
                }
        }
        return false;
    }
}
