package resources;

import model.Player;

public class GameMenuStrings {
    public static String getGameMenuString() {
        return "+------------------------------------+\n" +
                "+           ROOKIE REVENGE           +\n" +
                "+------------------------------------+\n" +
                " 1. PLAY               2. STATS\n" +
                " 3. HOW TO PLAY        4. SAVE\n" +
                " 5. SETTINGS           6. MENU\n" +
                "+------------------------------------+";
    }

    public static String getTeamString(Player player) {
        return "+------------------------------------+\n" +
                "                 STATS\n" +
                "+------------------------------------+\n" +
                " Rookie: " + player.getRookie().getName() + "\n" +
                player.getRookie().getStats() + "\n" +
                "+------------------------------------+\n" +
                "                 MOVES\n" +
                "+------------------------------------+\n" +
                " Attack --> " + player.getRookie().getMoves().get(0).getName() + "\n" +
                " Powerup --> " + player.getRookie().getMoves().get(1).getName() + "\n" +
                " Weaken --> " + player.getRookie().getMoves().get(2).getName() + "\n" +
                "+------------------------------------+\n" +
                "                 OTHER \n" +
                "+------------------------------------+\n" +
                " Gold: " + player.getGold() + "\n";

    }

    public static String getInstructionString() {
        return "+------------------------------------+\n" +
                "+             HOW TO PLAY            +\n" +
                "+------------------------------------+\n" +
                " Use Play to enter the Overworld and\n" +
                " begin your journey. Choose a location\n" +
                " and engage in battle to progress the\n" +
                " story. Conquer enough challenges in\n" +
                " each area to unlock new paths. \n" +
                " You can check your rookies stats in\n" +
                " the stats menu. \n" +
                "+------------------------------------+\n" +
                "+               BATTLE               +\n" +
                "+------------------------------------+\n" +
                " Combat is turn-based. The combatant \n" +
                " with the highest speed strikes first.\n" +
                " Use Moves to unleash powerful attacks,\n" +
                " activate power-ups, or weaken your \n" +
                " opponents defenses.\n" +
                "+------------------------------------+";
    }
    public static String getErrorText() {
        return "\n Not a valid input";
    }
    public static String getEnterText() {
        return "\n\n > Press enter to return.\n";
    }

    public static String getDevString() {
        return "+------------------------------------+\n" +
                "+             DEVELOPER             +\n" +
                "+------------------------------------+\n" +
                " 1. LEVEL UP           2. RETURN\n" +
                "+------------------------------------+";
    }
}
