package AdventureGame;

import java.io.Serializable;

public class Room implements Serializable {
    String description;
    Item item;
    Enemy enemy;

    public Room(String description, Item item, Enemy enemy) {
        this.description = description;
        this.item = item;
        this.enemy = enemy;
    }

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
}
