package AdventureGame;

import java.io.Serializable;
import java.util.HashSet;

public class GameState implements Serializable {
    private static final long serialVersionUID = 1L;

    Player player;
    Room[][] map;

    // Existing Features
    boolean[][] discovered;
    int turnCount;
    boolean questStarted;
    boolean questCompleted;
    int enemiesDefeated;
    int roomsVisited;
    boolean bossDefeated;
    HashSet<String> achievements;

    // NEW ADVANCED FEATURES
    String currentObjective;
    String difficultyLevel;
    int turnLimit;
    int puzzlesSolved;
    int shopVisits;
    String bossName;
    int totalGoldCollected;

    public GameState(Player player, Room[][] map,
                     boolean[][] discovered,
                     int turnCount,
                     boolean questStarted,
                     boolean questCompleted,
                     int enemiesDefeated,
                     int roomsVisited,
                     boolean bossDefeated,
                     HashSet<String> achievements,
                     String currentObjective,
                     String difficultyLevel,
                     int turnLimit,
                     int puzzlesSolved,
                     int shopVisits,
                     String bossName,
                     int totalGoldCollected) {

        this.player = player;
        this.map = map;
        this.discovered = discovered;
        this.turnCount = turnCount;
        this.questStarted = questStarted;
        this.questCompleted = questCompleted;
        this.enemiesDefeated = enemiesDefeated;
        this.roomsVisited = roomsVisited;
        this.bossDefeated = bossDefeated;
        this.achievements = achievements;

        this.currentObjective = currentObjective;
        this.difficultyLevel = difficultyLevel;
        this.turnLimit = turnLimit;
        this.puzzlesSolved = puzzlesSolved;
        this.shopVisits = shopVisits;
        this.bossName = bossName;
        this.totalGoldCollected = totalGoldCollected;
    }

    // Backward compatibility constructor
    public GameState(Player player, Room[][] map) {
        this(player, map, new boolean[3][3], 0, false, false, 0, 0, false,
                new HashSet<>(), "Explore the dungeon", "normal", 100,
                0, 0, "", 0);
    }
}
