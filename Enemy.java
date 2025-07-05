package AdventureGame;

import java.io.Serializable;
import java.util.Random;

public class Enemy implements Serializable {
    private static final long serialVersionUID = 1L;

    String name;
    int hp;
    int baseAttack;
    int defense;
    String type;
    int lootGold;
    int xpReward;
    String specialAbility;

    transient Random rand = new Random(); // not serialized

    public Enemy(String name, int hp, int baseAttack, int defense, String type, int lootGold, int xpReward, String specialAbility) {
        this.name = name;
        this.hp = hp;
        this.baseAttack = baseAttack;
        this.defense = defense;
        this.type = type;
        this.lootGold = lootGold;
        this.xpReward = xpReward;
        this.specialAbility = specialAbility;
    }

    public boolean isAlive() {
        return hp > 0;
    }

    public void takeDamage(int damage) {
        int actualDamage = Math.max(0, damage - defense);
        hp -= actualDamage;
        System.out.println(name + " takes " + actualDamage + " damage (after defense " + defense + ").");
    }

    public int attack() {
        int variability = rand.nextInt(5); // +/- variability
        int totalAttack = baseAttack + variability;
        System.out.println(name + " attacks for " + totalAttack + " damage.");
        return totalAttack;
    }

    public int getLootGold() {
        return lootGold;
    }

    public int getXpReward() {
        return xpReward;
    }

    public String getSpecialAbility() {
        return specialAbility;
    }

    @Override
    public String toString() {
        return name + " [" + type + "] (HP: " + hp + ", ATK: " + baseAttack + ", DEF: " + defense + ")";
    }
}
