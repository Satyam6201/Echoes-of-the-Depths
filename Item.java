package AdventureGame;

import java.io.Serializable;

public class Item implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private String type;        // e.g., "healing", "weapon", "xp", "key", "gold"
    private String description;

    private int healAmount;     // for healing items
    private int xpBoost;        // for XP scrolls
    private int damageBoost;    // for weapons
    private int durability;     // for weapons
    private int value;          // gold worth or cost
    private boolean isConsumable;

    // General constructor
    public Item(String name, String type, String description, int healAmount, int xpBoost, int damageBoost,
                int durability, int value, boolean isConsumable) {
        this.name = name;
        this.type = type;
        this.description = description;
        this.healAmount = healAmount;
        this.xpBoost = xpBoost;
        this.damageBoost = damageBoost;
        this.durability = durability;
        this.value = value;
        this.isConsumable = isConsumable;
    }

    // Simple constructor for healing items (legacy support)
    public Item(String name, int healAmount) {
        this(name, "healing", "Restores HP", healAmount, 0, 0, 1, 10, true);
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public int getHealAmount() {
        return healAmount;
    }

    public int getXpBoost() {
        return xpBoost;
    }

    public int getDamageBoost() {
        return damageBoost;
    }

    public int getDurability() {
        return durability;
    }

    public void reduceDurability() {
        if (durability > 0) durability--;
    }

    public int getValue() {
        return value;
    }

    public boolean isConsumable() {
        return isConsumable;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(" [").append(type).append("] - ").append(description);
        if (healAmount > 0) sb.append(" | Heals: ").append(healAmount);
        if (xpBoost > 0) sb.append(" | XP: ").append(xpBoost);
        if (damageBoost > 0) sb.append(" | Damage: +").append(damageBoost);
        if (durability > 0 && type.equals("weapon")) sb.append(" | Durability: ").append(durability);
        if (value > 0) sb.append(" | Value: ").append(value).append("g");
        return sb.toString();
    }
}
