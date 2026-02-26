package resources;

import model.*;

public class BattleStrings {
    public static String getBattleString(Rookie rookie, Rookie enemy) {
        return "+------------------------------------+\n" +
                "+             BATTLEGROUND           +\n" +
                "+------------------------------------+\n" +
                " " + enemy.getName() + " " + enemy.getLevelString() +"\n" +
                " " + enemy.getCurrentHealth() + "\n" +
                "\n" +
                " " + enemy.getArt() +
                " " + rookie.getArt() + "\n" +
                "                       " + rookie.getName() + " " + rookie.getLevelString() + "\n" +
                "                       " + rookie.getCurrentHealth() + "\n" +
                "+------------------------------------+\n" +
                " 1. ATTACK             2. POWER-UP\n" +
                " 3. WEAKEN             4. RUN\n" +
                "+------------------------------------+";
    }
    public static String getProcessingString(Rookie rookie, Rookie enemy) {
        return "+------------------------------------+\n" +
                "+             BATTLEGROUND           +\n" +
                "+------------------------------------+\n" +
                " " + enemy.getName() + " " + enemy.getLevelString() +"\n" +
                " " + enemy.getCurrentHealth() + "\n" +
                "\n" +
                " " + enemy.getArt() +
                " " + rookie.getArt() + "\n" +
                "                       " + rookie.getName() + " " + rookie.getLevelString() + "\n" +
                "                       " + rookie.getCurrentHealth() + "\n" +
                "+------------------------------------+\n" +
                "                BATTLE\n" +
                "              PROCESSING\n" +
                "+------------------------------------+";
    }
    public static String[] getInsults() {
        return new String[] {
                " got clapped.",
                " got bodied.",
                " got smoked.",
                " got absolutely wrecked.",
                " just got a reality check..",
                " got schooled."
        };
    }
}

