package AdventureGame;

import java.io.Serializable;

public class Item implements Serializable {
    String name;
    int healAmount;

    public Item(String name, int healAmount) {
        this.name = name;
        this.healAmount = healAmount;
    }

    public String getName() {
        return name;
    }

    public int getHealAmount() {
        return healAmount;
    }

    @Override
    public String toString() {
        return name + " (Heals: " + healAmount + ")";
    }
}
