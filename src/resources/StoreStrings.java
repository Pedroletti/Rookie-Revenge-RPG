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
                " 10. ROOKIE KICK, 1000g    [DMG: 55]\n" +
                " 11. PUKE ATTACK, 4000g    [DMG: 70]\n" +
                " 12. F-SIDEFLIP, 8000g     [DMG: 85]\n" +
                " 13. ROOKIE RAGE, 15000g   [DMG: 100]\n" +
                "+------------------------------------+\n" +
                "            POWERUP MOVES\n" +
                " 20. FLASH TUX, 1000g       [A: 30%]\n" +
                " 21. SELL PATCHES, 1000g    [D: 30%]\n" +
                " 22. EYBRO, 1000g           [S: 30%]\n" +
                " 23. PEA SOUP, 4000g        [A: 44%]\n" +
                " 24. SANTA'S LAP, 5000g     [D: 47%]\n" +
                " 25. PUNSCH, 6000g          [S: 50%]\n" +
                "+------------------------------------+\n" +
                "             WEAKEN MOVES\n" +
                " 30. CALCULUS, 1000g        [A: -30%]\n" +
                " 31. HUNGOVER, 1000g        [D: -30%]\n" +
                " 32. BENDER, 1000g          [S: -30%]\n" +
                " 33. TENGIL SITTING, 4000g  [D: -44%]\n" +
                " 34. FERNET, 5000g          [S: -47%]\n" +
                " 35. DUNKED, 6000g          [A: -50%]\n" +
                "+------------------------------------+";
    }

    public static String getStoreString(Player player) {
        return "+------------------------------------+\n" +
                "+                STORE              +\n" +
                "+             SANDWICH BAR          +\n" +
                "+------------------------------------+\n" +
                "   Purchasing a sandwich will add +1 \n" +
                "        to respective category \n" +
                "   (Health, Attack, Defense, Speed) \n" +
                "      Gluten bread is available!\n" +
                "              GOLD: " + player.getGold() + "\n" +
                "\n" +
                " 1. TVISTE (Goat Cheese, Pine Nuts)\n" +
                " Price: 2500g              [H+1]\n" +
                " 2. KANDIDAT (Ham, Cheese, Pineapple)\n" +
                " Price: 3000g              [D+1]\n" +
                " 3. FYSIK (Salami, Brie Cheese)\n" +
                " Price: 3500g              [S+1]\n" +
                " 4. MAGISTER (Chicken, Bacon, Cheese)\n" +
                " Price: 4000g              [A+1]\n" +
                " 5. RETURN\n" +
                "+------------------------------------+\n";
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
