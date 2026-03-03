package core;

import javax.swing.*;
import javax.swing.text.DefaultCaret;

import static resources.BattleStrings.getBattleString;
import static resources.MainMenuStrings.*;

import core.handlers.*;
import model.*;
import utils.SaveManager;
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
    public OverworldHandler overviewHandler;
    public BattleHandler battleHandler;
    public StoreHandler storeHandler;
    public boolean isProcessing;
    public Rookie enemy;
    public GameData data;
    public Battleground battleground;

    public enum GameState {
        MAIN_MENU, GAME_MENU, OVERWORLD, BATTLE, STORE, TRAINING, STORY
    }


    public GameManager(JTextArea display) {
        saveManager = new SaveManager();
        this.display = display;
        gameState = GameState.MAIN_MENU;
        isProcessing = false;
        data = new GameData();
        display.setText(getMenuString());
        menuHandler = new MainMenuHandler(this, sr, display);
        storeHandler = new StoreHandler(this, player, sr, display);
    }

    public void handleSelection(String choice) {
        if (choice.equalsIgnoreCase("exit")) System.exit(0);
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
                    overviewHandler = new OverworldHandler(this, player, sr, display);
                }
                overviewHandler.handleSelection(choice);
                break;
            case BATTLE:
                if(battleHandler == null) battleHandler = new BattleHandler(this, player, enemy, sr, display);
                battleHandler.handleSelection(choice);
                break;
            case TRAINING:
                storeHandler.handleTrainingSelection(choice);
                break;
            case STORY:
                playStory();
                break;
            case STORE:
                storeHandler.handleStoreSelection(choice);
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
        Timer timer = new Timer(600, null);
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

    public void loadBattle(boolean VS) {
        if(enemy.hasMessage()) {
            loadScene("...");
            gameState = GameState.STORY;
            return;
        }
        enemy.toggleMessage();

        DefaultCaret caret = (DefaultCaret) display.getCaret();
        caret.setUpdatePolicy(DefaultCaret.NEVER_UPDATE);
        display.setCaretPosition(0);

        isProcessing = true;
        display.setText("");
        final int flashes = 16;
        Timer timer3 = new Timer(30, new ActionListener() {
            private int count = 0;
            @Override
            public void actionPerformed(ActionEvent e) {
                int maxNewLines = 40 - count;
                String padding = "\n".repeat(Math.max(0, maxNewLines));
                display.setText(padding + getBattleString(player.getRookie(), enemy));
                count++;
                if (count > 40) {
                    gameState = GameState.BATTLE;
                    isProcessing = false;
                    caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
                    ((Timer) e.getSource()).stop();
                }
            }
        });
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
                        ((Timer)e.getSource()).stop();
                        timer3.start();
                }
            }
        });
        Timer timer = new Timer(100, new ActionListener() {
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
                    if(VS) timer2.start();
                    else timer3.start();
                }
            }
        });
        timer.start();
    }

    private void playStory() {
        if (sr == null) {
            sr = new StringReader(enemy.getMessage());
        }
        String nextText = sr.next();

        if (nextText != null) {
            if (sr.isFirstLine())
                display.setText(nextText + "\n");
            else
                display.append(nextText + "\n");
        } else {
            sr = null;
            enemy.toggleMessage();
            loadBattle(true);
        }
    }
}
