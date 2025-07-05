package AdventureGame;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Player implements Serializable {
    String name;
    int hp;
    int xp;
    int level;
    List<Item> inventory;
    int x, y; // Position on map

    public Player(String name) {
        this.name = name;
        this.hp = 100;
        this.xp = 0;
        this.level = 1;
        this.x = 0;
        this.y = 0;
        this.inventory = new ArrayList<>();
    }

    public void addItem(Item item) {
        inventory.add(item);
    }

    public void heal(int amount) {
        hp = Math.min(100, hp + amount);
    }

    public void gainXP(int xpGain) {
        xp += xpGain;
        if (xp >= level * 50) {
            level++;
            hp = 100;
            System.out.println("You leveled up to " + level + "!");
        }
    }

    public boolean isAlive() {
        return hp > 0;
    }

    public void takeDamage(int damage) {
        hp -= damage;
    }

    public List<Item> getInventory() {
        return inventory;
    }

    @Override
    public String toString() {
        return name + " | HP: " + hp + " | XP: " + xp + " | Level: " + level;
    }
}
