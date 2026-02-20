package resources;

import model.Player;

public class MainMenuStrings {
    public static String getMenuString() {
        return "+------------------------------------+\n" +
                "+           ROOKIE REVENGE           +\n" +
                "+------------------------------------+\n" +
                " 1. START              2. SETTINGS\n" +
                " 3. CREDITS            4. EXIT\n" +
                "+------------------------------------+";
    }
    public static String getSaveSlotString() {
        return "+------------------------------------+\n" +
                "+           ROOKIE REVENGE           +\n" +
                "+------------------------------------+\n" +
                " 1. CONTINUE           2. NEW GAME\n" +
                " 3. RETURN\n" +
                "+------------------------------------+";
    }
    public static String getConfirmText() {
        return "+------------------------------------+\n" +
                "+            ARE YOU SURE?           +\n" +
                "+------------------------------------+\n" +
                " 1. YES                2. NO\n" +
                "+------------------------------------+";
    }
    public static String getRookieChoice() {
        return "+------------------------------------+\n" +
                " 1. SIGGE              2. HANS\n" +
                " 3. EMMA               4. OTTO\n" +
                "+------------------------------------+";
    }
    public static String[] getIntroTexts() {
        return new String[] {
                "Welcome to the world of Rookies!",
                "Rookies are the filth of this world,\nand they are looked upon with disgust.",
                "Everything a rookie wants is to ascend\nas a full fledged member of the",
                "PIRAYA SOCIETY.",
                "But, there are evil pirayas who's\ntrying to stop rookies from\nachieving this goal.",
                "To ascend, you as a player must\ndefeat these evil entities and ascend\ninto the higher realms.",
                "But before that I must ask.."
        };
    }

    public static String[] getIntroChoiceTexts(Player player) {
        return new String[] {
                "So " + player.getName() + " is your name..",
                player.getName() + ", to begin your journey,",
                "please pick a rookie that will \naccompany you."
        };
    }
    public static String[] getOutroTexts(Player player) {
        return new String[] {
                "So, your choice is " + player.getRookie().getName() + "!",
                player.getRookie().getName() + " will accompany you through the\ndeepest of trenches and the highest\npeaks of our world.",
                "Together, you shall defy the evil\nPirayas and prove that even a\n'Rookie' has the heart of a legend.",
                "Your journey to the Higher Realms\nbegins... NOW!",
        };
    }
    public static String getSettingsText() {
        return getMenuString() + "\n [ SETTINGS ]\n No settings yet";
    }
    public static String getCreditsText() {
        return getMenuString() + "\n [ CREDITS ]\n github.com/pedroletti\n[ ASCII ART ]\n Modified & Used art from\n asciiart.eu";
    }
}
