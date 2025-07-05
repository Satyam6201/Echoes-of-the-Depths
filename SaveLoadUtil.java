package AdventureGame;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SaveLoadUtil {

    private static final String BACKUP_FOLDER = "saves/";
    private static final String SAVE_VERSION = "1.0";

    // Save game with backup
    public static void save(GameState state, String filename) throws IOException {
        // Ensure folder exists
        Files.createDirectories(Paths.get(BACKUP_FOLDER));

        // Backup previous save
        File original = new File(filename);
        if (original.exists()) {
            String backupName = BACKUP_FOLDER + "backup_" + timeStamp() + ".dat";
            Files.copy(original.toPath(), Paths.get(backupName));
            System.out.println("📦 Backup created: " + backupName);
        }

        // Add save version info
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            out.writeUTF(SAVE_VERSION); // Save version
            out.writeObject(state);
            System.out.println("✅ Game saved successfully!");
        } catch (IOException e) {
            System.err.println("❌ Failed to save game: " + e.getMessage());
            throw e;
        }
    }

    // Load game
    public static GameState load(String filename) throws IOException, ClassNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            String version = in.readUTF(); // Read version info
            if (!version.equals(SAVE_VERSION)) {
                System.out.println("⚠️ Save version mismatch. Save: " + version + ", Expected: " + SAVE_VERSION);
                // You could add migration logic here
            }

            GameState state = (GameState) in.readObject();
            System.out.println("✅ Game loaded successfully.");
            return state;
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("❌ Failed to load game: " + e.getMessage());
            throw e;
        }
    }

    // Generate timestamp for backup names
    private static String timeStamp() {
        return new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
    }
}
