package utils;
import core.GameData;

import java.io.*;

public class SaveManager {
    private static final String SAVE_DIR = getAppDataFolder();
    private static final String SAVE_FILE_NAME = "savegame.dat";
    private static final String FULL_PATH = SAVE_DIR + File.separator + SAVE_FILE_NAME;

    public boolean saveGame(GameData data) {
        try {
            File folder = new File(SAVE_DIR);
            if (!folder.exists()) {
                folder.mkdirs();
            }
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FULL_PATH))) {
                oos.writeObject(data);
                return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public GameData loadGame() {
        File file = new File(FULL_PATH);
        if (!file.exists()) {
            return null;
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FULL_PATH))) {
            return (GameData) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void deleteSaveGame() {
        File file = new File(FULL_PATH);
        if (file.exists()) {
            file.delete();
        }
    }

    private static String getAppDataFolder() {
        String os = System.getProperty("os.name").toLowerCase();
        String userHome = System.getProperty("user.home");

        if (os.contains("win")) {
            return System.getenv("AppData") + File.separator + "RR-RPG";
        } else if (os.contains("mac")) {
            return userHome + "/Library/Application Support/RR-RPG";
        } else {
            return userHome + File.separator + ".RR-RPG";
        }
    }

    public static String getSaveLocation() {
        return FULL_PATH;
    }
}