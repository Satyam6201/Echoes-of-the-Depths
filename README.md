# 🧭 Terminal-Based 2D Adventure Game (Java)

A terminal-based 2D RPG adventure game written in Java using **Object-Oriented Programming** principles.  
Explore rooms, fight enemies, collect items, level up, and save/load your journey!

---

## 🚀 Features

### 🎮 Gameplay Mechanics
- 3x3 grid map exploration
- Turn-based enemy battles
- Random loot and item drops
- RPG stats: **HP, XP, Leveling, Inventory**

### 💼 Inventory System
- **Healing Items**: Restore HP
- **XP Scrolls**: Gain experience
- **Weapons**: Deal extra damage
- Items can be **durable** or **consumable**

### 🧠 Enemies
- Each enemy has:
  - Name, HP, Base Attack, Defense
  - XP reward, gold loot
  - Optional **special abilities** like `Burn`, `Stun`

### 🗃️ Save/Load Game State
- Uses Java Serialization to persist:
  - Player state
  - Inventory and stats
  - Room states (items/enemies)
  - Map discovery (fog of war)

### 🧭 Map & Movement
- `north`, `south`, `east`, `west` to move
- `map` command to show explored areas
- `P`: Player, `E`: Enemy, `I`: Item, `?`: Unexplored

---

## 📦 File Structure
```
AdventureGame/
├── Game.java // Main game loop
├── GameState.java // Serializable game data
├── Player.java // Player logic and stats
├── Enemy.java // Enemy logic and stats
├── Item.java // Items with types, effects
├── Room.java // Each cell in map
├── SaveLoadUtil.java // Save/load system
└── save.dat // (Created after first save)
```

---

## 📖 How to Play

1. **Compile the code:**
   ```bash
   javac AdventureGame/*.java
2. Run the game:

  bash
  Copy code
  java AdventureGame.Game

3. Commands during gameplay:

   * north, south, east, west — Move on the map

   * attack — Attack an enemy

   *  use — Use an item (auto-uses the first one)

   *  inventory — View items in your bag

   *  map — View the explored map

   *  save — Save progress to save.dat

   *  exit — Quit the game

🧠 Concepts Used

Concept	Usage
| Concept               | Usage                                                                  |
| --------------------- | ---------------------------------------------------------------------- |
| OOP (Object-Oriented) | Player, Enemy, Item, Room, GameState, SaveLoadUtil                     |
| Arrays & 2D Arrays    | Grid-based room map (`Room[][]`) and discovery map (`boolean[][]`)     |
| Collections           | `ArrayList` for inventory, `HashSet` for achievements                  |
| Serialization         | Save/load game state with `ObjectOutputStream` and `ObjectInputStream` |
| Randomization         | Random loot, crit hits, dodge chance                                   |
| Conditionals/Loops    | Battle system, turn loop, command handling                             |

🧪 Sample Gameplay

```
Load previous game? (yes/no): no

===== Turn 1 =====
Player(Hero) HP: 100 Level: 1 XP: 0
Map:
[P] [?] [?]
[?] [?] [?]
[?] [?] [?]
You're in: A quiet room.
Found item: Health Potion (Heals: 20)
Available commands: north, south, east, west, save, exit, inventory, map
> east
A wild Goblin (HP: 30) appears!
Attack or use item?
> attack
You hit the enemy! Enemy HP: 10
Enemy hit you! Your HP: 90
...
You defeated Goblin!
You gained 20 XP!
```
🏆 Future Feature Ideas
   * 🔑 Locked rooms and key items

   * 🛒 Shop rooms to buy/sell items

   * 🧩 Puzzle rooms and side quests

   * 👑 Boss battles with cutscenes

   * 💬 NPC dialogue and interactions
   
🧑‍💻 Author
Made by Satyam Kumar Mishra
LinkedIn | GitHub: @Satyam6201
