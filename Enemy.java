package AdventureGame;

import java.io.Serializable;

public class Enemy implements Serializable {
    String name;
    int hp;
    int attack;

    public Enemy(String name, int hp, int attack) {
        this.name = name;
        this.hp = hp;
        this.attack = attack;
    }

    public boolean isAlive() {
        return hp > 0;
    }

    public void takeDamage(int damage) {
        hp -= damage;
    }

    public int attack() {
        return attack;
    }

    @Override
    public String toString() {
        return name + " (HP: " + hp + ")";
    }
}
