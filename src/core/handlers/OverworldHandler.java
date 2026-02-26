package core.handlers;

import core.GameManager;
import model.Battleground;
import model.Player;
import model.Rookie;
import utils.StringReader;

import javax.swing.*;

import static java.lang.Integer.parseInt;
import static resources.GameMenuStrings.getGameMenuString;
import static resources.GameMenuStrings.getErrorText;
import static resources.StoreStrings.*;

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
            case "13":
                gameManager.gameState = GameManager.GameState.GAME_MENU;
                display.setText(getGameMenuString());
                break;
            default:
                handleBattle(parseInt(choice));
                break;
        }
    }
    public void updatePlayer(Player player) {
        this.player = player;
    }

    public void handleBattle(int battlegroundId) {
        battlegroundId -= 1;
        if(battlegroundId < 0 || battlegroundId > gameManager.data.battlegrounds.size()-1) {
            display.append(getErrorText());
            return;
        }
        Battleground battleground = gameManager.data.battlegrounds.get(battlegroundId);
        if (!gameManager.player.isDev()) {
            if (battleground.isLocked()) {
                if (!unlockBattleground(battlegroundId)) {
                    display.append("\n Battleground is locked!");
                    return;
                }
            }
        }
        if (battleground.isDefeated() && battleground.isGym()) {
            if (battleground.isTraining()) {
                gameManager.gameState = GameManager.GameState.TRAINING;
                gameManager.loadScene(getTrainingString(player));
            } else if (battleground.isStore()) {
                gameManager.gameState = GameManager.GameState.STORE;
                gameManager.loadScene(getStoreString(player));
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
        if (gameManager.data.battlegrounds.get(battlegroundId - 1).isDefeated()) {
            gameManager.data.battlegrounds.get(battlegroundId).setLocked(false);
            return true;
        } else return false;
    }
}
