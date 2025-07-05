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

