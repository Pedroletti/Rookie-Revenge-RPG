package core.handlers;
import core.GameManager;
import utils.StringReader;
import model.Player;
import model.Rookie;
import javax.swing.*;

import static resources.MainMenuHandler.*;
import static resources.GameMenuStrings.*;
import static resources.ascii.Characters.*;

public class MainMenuHandler {
    private final JTextArea display;
    private final GameManager gameManager;
    private MenuState menuState;
    private SubState subState;
    private StringReader sr;
    private Player player;

    public enum MenuState {
        MAIN_MENU, GAME_SELECTION, INTRO_STORY, NAMING_PLAYER, STARTER
    }
    public enum SubState {
        CONFIRM, IDLE, INTRO_STORY_1, INTRO_STORY_2, INTRO_STORY_3
    }

    public MainMenuHandler(GameManager gameManager, StringReader sr, JTextArea display) {
        this.display = display;
        this.gameManager = gameManager;
        this.sr = sr;
        menuState = MenuState.MAIN_MENU;
        subState = SubState.IDLE;
    }

    public void handleSelection(String choice) {
        switch(menuState) {
            case MAIN_MENU:
                handleMenuSelection(choice);
                break;
            case GAME_SELECTION:
                handleGameSelection(choice);
                break;
            case INTRO_STORY:
                if (subState == SubState.INTRO_STORY_1)
                    playStory(getIntroTexts());
                else if (subState == SubState.INTRO_STORY_2)
                    playStory(getIntroChoiceTexts(player));
                else if (subState == SubState.INTRO_STORY_3)
                    playStory(getOutroTexts(player));
                break;
            case NAMING_PLAYER:
                handleNameInput(choice);
                break;
            case STARTER:
                handleRookieChoice(choice);
                break;
        }
    }

    private void handleMenuSelection(String choice) {
        switch (choice) {
            case "1":
                menuState = MenuState.GAME_SELECTION;
                display.setText(getSaveSlotString());
                break;
            case "2":
                display.setText(getSettingsText());
                break;
            case "3":
                display.setText(getCreditsText());
                break;
            case "4":
                System.exit(0);
                break;
            default:
                display.append(getErrorText());
                break;
        }
    }

    private void handleGameSelection(String choice) {
        switch (choice) {
            case "1":
                if(!gameManager.loadGame()) {
                    display.append("\n No save file found.");
                } else {
                    gameManager.loadScene(getGameMenuString());
                    gameManager.gameState = GameManager.GameState.GAME_MENU;
                    menuState = MenuState.MAIN_MENU;
                    subState = SubState.IDLE;
                }
                break;
            case "2":
                menuState = MenuState.INTRO_STORY;
                subState = SubState.INTRO_STORY_1;
                gameManager.deleteGame();
                gameManager.data.buildWorld();
                playStory(getIntroTexts());
                break;
            case "3":
                menuState = MenuState.MAIN_MENU;
                display.setText(getMenuString());
                break;
            default:
                display.append(getErrorText());
                break;
        }
    }

    public void handleNameInput(String name) {
        if (!name.matches("^[a-zA-ZåäöÅÄÖ]+$")) {
            display.append("\n Invalid name. Use only letters.");
            return;
        }
        player = new Player(name);
        gameManager.updatePlayer(player);
        menuState = MenuState.INTRO_STORY;
        subState = SubState.INTRO_STORY_2;
        display.append("\nThat has a powerful ring to it.\n");
    }

    public void handleRookieChoice(String name) {
        switch(name) {
            case "1":
                Rookie sigge = new Rookie("Sigge");
                sigge.addMove(gameManager.data.moveCatalog.get("PUNCH"));
                sigge.addMove(gameManager.data.moveCatalog.get("GUINNESS"));
                sigge.addMove(gameManager.data.moveCatalog.get("MEAN WORDS"));
                sigge.levelUp(4);
                sigge.setArt(getSiggeArt());
                player.setRookie(sigge);
                break;
            case "2":
                Rookie hans = new Rookie("Hans");
                hans.addMove(gameManager.data.moveCatalog.get("PUNCH"));
                hans.addMove(gameManager.data.moveCatalog.get("GUINNESS"));
                hans.addMove(gameManager.data.moveCatalog.get("MEAN WORDS"));
                hans.levelUp(4);
                hans.setArt(getHansArt());
                player.setRookie(hans);
                break;
            case "3":
                Rookie emma = new Rookie("Emma");
                emma.addMove(gameManager.data.moveCatalog.get("PUNCH"));
                emma.addMove(gameManager.data.moveCatalog.get("ARTON56"));
                emma.addMove(gameManager.data.moveCatalog.get("STARE"));
                emma.levelUp(4);
                emma.setArt(getEmmaArt());
                player.setRookie(emma);
                break;
            case "4":
                Rookie otto = new Rookie("Otto");
                otto.addMove(gameManager.data.moveCatalog.get("PUNCH"));
                otto.addMove(gameManager.data.moveCatalog.get("EYBRO"));
                otto.addMove(gameManager.data.moveCatalog.get("TAUNT"));
                otto.levelUp(4);
                otto.setArt(getOttoArt());
                player.setRookie(otto);
                break;
            default:
                display.append(getErrorText());
                return;
        }
        gameManager.updatePlayer(player);
        menuState = MenuState.INTRO_STORY;
        subState = SubState.INTRO_STORY_3;
        display.append("\nAn excellent partner for your journey.\n");
    }

    private void playStory(String[] text) {
        if (sr == null) {
            sr = new StringReader(text);
        }
        String nextText = sr.next();

        if (nextText != null) {
            if (sr.isFirstLine())
                display.setText(nextText + "\n");
            else
                display.append(nextText + "\n");
        } else {
            sr = null;
            if (subState == SubState.INTRO_STORY_1) {
                display.append("\n> What is your name?");
                menuState = MenuState.NAMING_PLAYER;
            } else if (subState == SubState.INTRO_STORY_2) {
                display.append(getRookieChoice());
                display.append("\n> What rookie do you choose?\n");
                menuState = MenuState.STARTER;
            } else if (subState == SubState.INTRO_STORY_3) {
                gameManager.loadScene(getGameMenuString());
                gameManager.gameState = GameManager.GameState.GAME_MENU;
                menuState = MenuState.MAIN_MENU;
                subState = SubState.IDLE;
                if(!gameManager.saveGame())
                    display.append("\n Could not save game ");
            } else {
                subState = SubState.IDLE;
            }
        }
    }
}
