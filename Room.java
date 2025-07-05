package AdventureGame;

import java.io.Serializable;

public class Room implements Serializable {
    private static final long serialVersionUID = 1L;

    private String description;
    private Item item;
    private Enemy enemy;

    // New features
    private boolean visited;
    private boolean isLocked;
    private boolean isShop;
    private boolean isPuzzleRoom;
    private boolean isTrapRoom;
    private boolean isBossRoom;

    private String npcDialogue;
    private String requiresKeyName;

    public Room(String description, Item item, Enemy enemy,
                boolean isLocked, boolean isShop, boolean isPuzzleRoom,
                boolean isTrapRoom, boolean isBossRoom,
                String npcDialogue, String requiresKeyName) {
        this.description = description;
        this.item = item;
        this.enemy = enemy;

        this.isLocked = isLocked;
        this.isShop = isShop;
        this.isPuzzleRoom = isPuzzleRoom;
        this.isTrapRoom = isTrapRoom;
        this.isBossRoom = isBossRoom;

        this.npcDialogue = npcDialogue;
        this.requiresKeyName = requiresKeyName;
        this.visited = false;
    }

    // Basic constructor for simple rooms
    public Room(String description, Item item, Enemy enemy) {
        this(description, item, enemy, false, false, false, false, false, null, null);
    }

    // Getters and logic
    public String getDescription() {
        return description;
    }

    public Item getItem() {
        return item;
    }

    public Enemy getEnemy() {
        return enemy;
    }

    public void removeItem() {
        this.item = null;
    }

    public void defeatEnemy() {
        this.enemy = null;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public boolean isLocked() {
        return isLocked;
    }

    public boolean isShop() {
        return isShop;
    }

    public boolean isPuzzleRoom() {
        return isPuzzleRoom;
    }

    public boolean isTrapRoom() {
        return isTrapRoom;
    }

    public boolean isBossRoom() {
        return isBossRoom;
    }

    public String getNpcDialogue() {
        return npcDialogue;
    }

    public String getRequiresKeyName() {
        return requiresKeyName;
    }

    public void unlockRoom() {
        this.isLocked = false;
    }
}
