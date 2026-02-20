package resources;

import model.Player;

public class StoreStrings {
    public static String getTrainingString(Player player) {
        return "+------------------------------------+\n" +
                "+              TRAINING             +\n" +
                "+------------------------------------+\n" +
                " Purchasing a move will replace your\n" +
                "    current move in that category\n" +
                "     (Attack, Power-up or Weaken)\n" +
                "              GOLD: " + player.getGold() + "\n" +
                "\n" +
                " 1. TALK               2. RETURN\n" +
                "+------------------------------------+\n" +
                "             ATTACK MOVES\n" +
                " 10. ROOKIE KICK, 500g     [DMG: 55]\n" +
                " 11. PUKE ATTACK, 1500g    [DMG: 70]\n" +
                " 12. F-SIDEFLIP, 3000g     [DMG: 85]\n" +
                " 13. ROOKIE RAGE, 5000g    [DMG: 100]\n" +
                "+------------------------------------+\n" +
                "            POWERUP MOVES\n" +
                " 20. FLASH TUX, 350g       [A: 30%]\n" +
                " 21. SELL PATCHES, 350g    [D: 30%]\n" +
                " 22. EYBRO, 350g           [S: 30%]\n" +
                " 23. PEA SOUP, 1200g       [A: 44%]\n" +
                " 24. SANTA'S LAP, 1350g    [D: 47%]\n" +
                " 25. PUNSCH, 1500g         [S: 50%]\n" +
                "+------------------------------------+\n" +
                "             WEAKEN MOVES\n" +
                " 30. CALCULUS, 1000g       [A: -30%]\n" +
                " 31. HUNGOVER, 1000g       [D: -30%]\n" +
                " 32. BENDER, 1000g         [S: -30%]\n" +
                " 33. TENGIL SITTING, 3000g [D: -44%]\n" +
                " 34. FERNET, 3500g         [D: -47%]\n" +
                " 35. DUNKED, 4000g         [A: -50%]\n" +
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
    public static String getConfirmText() {
        return "+------------------------------------+\n" +
                "+            ARE YOU SURE?           +\n" +
                "+------------------------------------+\n" +
                " 1. YES                2. NO\n" +
                "+------------------------------------+";
    }
}
