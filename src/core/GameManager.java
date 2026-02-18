package core;

import javax.swing.*;

import static resources.BattleStrings.getBattleString;
import static resources.MainMenuHandler.*;

import core.handlers.BattleHandler;
import core.handlers.GameMenuHandler;
import core.handlers.MainMenuHandler;
import core.handlers.OverviewHandler;
import model.*;
import utils.StringReader;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameManager {
    private SaveManager saveManager;
    private JTextArea display;
    public Player player;
    public GameState gameState;
    private StringReader sr;
    private MainMenuHandler menuHandler;
    public GameMenuHandler gameHandler;
    private OverviewHandler overviewHandler;
    public BattleHandler battleHandler;
    public boolean isProcessing;
    public Rookie enemy;
    public GameData data;
    public Battleground battleground;

    public enum GameState {
        MAIN_MENU, GAME_MENU, OVERWORLD, BATTLE
    }


    public GameManager(JTextArea display) {
        saveManager = new SaveManager();
        this.display = display;
        gameState = GameState.MAIN_MENU;
        menuHandler = new MainMenuHandler(this, sr, display);
        isProcessing = false;
        data = new GameData();
        display.setText(getMenuString());
    }

    public void handleSelection(String choice) {
        if (isProcessing) return;
        switch(gameState) {
            case MAIN_MENU:
                menuHandler.handleSelection(choice);
                break;
            case GAME_MENU:
                if(gameHandler == null) {
                    gameHandler = new GameMenuHandler(this, player, display);
                }
                gameHandler.handleSelection(choice);
                break;
            case OVERWORLD:
                if(overviewHandler == null) {
                    overviewHandler = new OverviewHandler(this, player, display);
                }
                overviewHandler.handleSelection(choice);
                break;
            case BATTLE:
                if(battleHandler == null) battleHandler = new BattleHandler(this, player, enemy, sr, display);
                battleHandler.handleSelection(choice);
        }
    }

    public void updatePlayer(Player player) {
        if(player != null) {
            this.player = player;
            data.updatePlayer(player);
        }
    }

    public void setEnemy(Rookie enemy) {
        this.enemy = enemy;
    }

    public void setBattleground(Battleground battleground) {
        this.battleground = battleground;
    }

    public boolean saveGame() {
        data.updatePlayer(player);
        return saveManager.saveGame(data);
    }

    public boolean loadGame() {
        data = saveManager.loadGame();
        if(data == null) {
            data = new GameData();
            return false;
        }
        this.player = data.getPlayer();
        return true;
    }

    public void deleteGame() {
        saveManager.deleteSaveGame();
        battleHandler = null;
        gameHandler = null;
        overviewHandler = null;
    }

    public void loadScene(String sceneString) {
        isProcessing = true;
        display.append("\n Loading");
        Timer timer = new Timer(400, null);
        timer.addActionListener(new ActionListener() {
            int count = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                if (count < 3) {
                    display.append(".");
                    count++;
                } else {
                    isProcessing = false;
                    display.setText(sceneString);
                    ((Timer)e.getSource()).stop();
                }
            }
        });
        timer.start();
    }

    public void loadBattle(Player player, Rookie enemy) {
        display.setText("");
        final int flashes = 10;
        Timer timer2 = new Timer(600, new ActionListener() {
            private int count = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                switch (count) {
                    case 0:

                        display.append("\n\n\n\n\n\n       " + player.getRookie().getName());
                        count++;
                        break;
                    case 1:
                        display.append("\n       VS.");
                        count++;
                        break;
                    case 2:
                        display.append("\n       " + enemy.getName());
                        count++;
                        break;
                    case 3:
                        count++;
                        break;
                    default:
                        display.setText(getBattleString(player.getRookie(), enemy));
                        ((Timer)e.getSource()).stop();
                }
            }
        });
        Timer timer = new Timer(150, new ActionListener() {
            private int count = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                if (count < flashes) {
                    if (count % 2 == 0) {
                        display.setBackground(Color.WHITE);
                    } else {
                        display.setBackground(Color.BLACK);
                    }
                    count++;
                } else {
                    display.setBackground(Color.BLACK);
                    ((Timer)e.getSource()).stop();
                    timer2.start();
                }
            }
        });
        timer.start();
    }
}
