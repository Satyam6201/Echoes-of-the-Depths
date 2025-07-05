package AdventureGame;

import java.util.*;

public class Game {
    static Scanner scanner = new Scanner(System.in);
    static Room[][] map = new Room[3][3];
    static Player player;
    static boolean[][] discovered = new boolean[3][3];
    static int turnCount = 0;

    public static void main(String[] args) {
        System.out.println("Load previous game? (yes/no):");
        if (scanner.nextLine().equalsIgnoreCase("yes")) {
            try {
                GameState state = SaveLoadUtil.load("save.dat");
                player = state.player;
                map = state.map;
                System.out.println("Game loaded successfully!");
            } catch (Exception e) {
                System.out.println("Failed to load game. Starting new...");
                setupNewGame();
            }
        } else {
            setupNewGame();
        }

        gameLoop();
    }

    static void setupNewGame() {
        player = new Player("Hero");

        // Random map setup
        map[0][0] = new Room("A quiet room.", new Item("Health Potion", 20), null);
        map[0][1] = new Room("Dark corridor.", null, new Enemy("Goblin", 30, 5));
        map[0][2] = new Room("Treasure chamber.", new Item("XP Scroll", 0), null);
        map[1][0] = new Room("Dungeon entrance.", null, new Enemy("Skeleton", 40, 8));
        map[1][1] = new Room("Central hub.", null, null);
        map[1][2] = new Room("Mystic hall.", new Item("Elixir", 50), new Enemy("Mage", 50, 10));
        map[2][0] = new Room("Armory.", new Item("Shield", 0), null);
        map[2][1] = new Room("Beast lair.", null, new Enemy("Wolf", 35, 6));
        map[2][2] = new Room("Exit gate.", null, null);
    }

    static void gameLoop() {
        while (player.isAlive()) {
            turnCount++;
            discovered[player.x][player.y] = true;

            System.out.println("\n===== Turn " + turnCount + " =====");
            System.out.println(player);
            printMap();

            Room room = map[player.x][player.y];
            System.out.println("You're in: " + room.getDescription());

            if (room.getEnemy() != null && room.getEnemy().isAlive()) {
                battle(room.getEnemy());
                if (!player.isAlive()) break;
                room.defeatEnemy();
            }

            if (room.getItem() != null) {
                System.out.println("Found item: " + room.getItem());
                player.addItem(room.getItem());
                room.removeItem();
            }

            System.out.println("Available commands: north, south, east, west, save, exit, inventory, map");
            String input = scanner.nextLine().toLowerCase();

            switch (input) {
                case "save":
                    try {
                        SaveLoadUtil.save(new GameState(player, map), "save.dat");
                        System.out.println("Game saved.");
                    } catch (Exception e) {
                        System.out.println("Save failed.");
                    }
                    continue;
                case "exit":
                    System.out.println("Exiting game...");
                    return;
                case "inventory":
                    showInventory();
                    continue;
                case "map":
                    printMap();
                    continue;
                default:
                    move(input);
            }
        }

        if (!player.isAlive()) {
            System.out.println("You died! Game Over.");
            showStats();
        } else {
            System.out.println("Game exited.");
            showStats();
        }
    }

    static void move(String dir) {
        int newX = player.x;
        int newY = player.y;

        switch (dir) {
            case "north": newX--; break;
            case "south": newX++; break;
            case "east": newY++; break;
            case "west": newY--; break;
            default:
                System.out.println("Invalid direction.");
                return;
        }

        if (newX >= 0 && newX < 3 && newY >= 0 && newY < 3) {
            player.x = newX;
            player.y = newY;
        } else {
            System.out.println("You hit a wall.");
        }
    }

    static void battle(Enemy enemy) {
        System.out.println("A wild " + enemy + " appears!");

        while (enemy.isAlive() && player.isAlive()) {
            System.out.println("Attack or use potion?");
            String action = scanner.nextLine();

            if (action.equalsIgnoreCase("attack")) {
                boolean crit = Math.random() < 0.1;
                int damage = crit ? 40 : 20;
                enemy.takeDamage(damage);
                System.out.println(crit ? "CRITICAL HIT!" : "You hit the enemy! Enemy HP: " + enemy.hp);
            } else if (action.toLowerCase().startsWith("use")) {
                if (!player.inventory.isEmpty()) {
                    Item item = player.inventory.remove(0);
                    player.heal(item.getHealAmount());
                    System.out.println("Used " + item + ". Your HP: " + player.hp);
                } else {
                    System.out.println("No items to use.");
                }
            }

            if (enemy.isAlive()) {
                boolean dodge = Math.random() < 0.15;
                if (dodge) {
                    System.out.println("You dodged the attack!");
                } else {
                    player.takeDamage(enemy.attack());
                    System.out.println("Enemy hit you! Your HP: " + player.hp);
                }
            }
        }

        if (player.isAlive()) {
            System.out.println("You defeated " + enemy.name + "!");
            player.gainXP(25);
        }
    }

    static void showInventory() {
        System.out.println("\nInventory:");
        if (player.inventory.isEmpty()) {
            System.out.println("Empty");
        } else {
            for (Item item : player.inventory) {
                System.out.println("- " + item);
            }
        }
    }

    static void printMap() {
        System.out.println("\nMap:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (player.x == i && player.y == j) {
                    System.out.print("[P] ");
                } else if (discovered[i][j]) {
                    System.out.print("[ ] ");
                } else {
                    System.out.print("[?] ");
                }
            }
            System.out.println();
        }
    }

    static void showStats() {
        System.out.println("===== Game Summary =====");
        System.out.println("Name: " + player.name);
        System.out.println("Level: " + player.level);
        System.out.println("XP: " + player.xp);
        System.out.println("Turns Taken: " + turnCount);
    }
}
