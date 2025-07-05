package AdventureGame;

import java.io.Serializable;
import java.util.HashSet;

public class GameState implements Serializable {
    Player player;
    Room[][] map;

    // NEW FEATURES
    boolean[][] discovered;            // Fog of war: rooms visited
    int turnCount;                     // Number of actions taken
    boolean questStarted;              // Side quest tracker
    boolean questCompleted;
    int enemiesDefeated;              // Enemies defeated count
    int roomsVisited;                 // Number of unique rooms visited
    boolean bossDefeated;             // Final boss status
    HashSet<String> achievements;     // Achievement list

    public GameState(Player player, Room[][] map,
                     boolean[][] discovered,
                     int turnCount,
                     boolean questStarted,
                     boolean questCompleted,
                     int enemiesDefeated,
                     int roomsVisited,
                     boolean bossDefeated,
                     HashSet<String> achievements) {

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
    }

    // Optional: default constructor for partial saves or backward compatibility
    public GameState(Player player, Room[][] map) {
        this(player, map, new boolean[3][3], 0, false, false, 0, 0, false, new HashSet<>());
    }
}
