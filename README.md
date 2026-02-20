# Rookie Revenge
Rookie Revenge RPG is a text-based, turn-based RPG game made in Java. Set in an environment based on locations from [Umeå, Sweden], the game allows players to recruit and level up unique characters known as 'Rookies'. Explore various battlegrounds, engage in strategic battles to gain gold and experience and reach the top to defeat the evil enteties called "Pirayas".

![Image not found](/assets/preview.png)

## Features
* **Turn Based Combat:** A logic-driven battle system featuring standard attacks, stat modifiers (Powerup/Weaken), dodging and critical hits.
* **Dynamic World:** Includes unique battlegrounds such as MIT-huset, Data Gym, and Naturvetarhuset, each with specific enemies and difficulty scaling.
* **Progression System:** Players can level up their Rookies, learn new abilities from a move catalog, and accumulate gold through victories.
* **Save & Load System:** Features built-in persistence to save and resume game progress via serialized data handling.

## Project Structure
```
Rookie-Revenge-RPG/
├── src/                    # Source code
│   ├── core/               # Engine and main logic (GameManager, GameData)
│   │   └── handlers/       # Logic for specific states (Battle, Menu, Overview)
│   ├── model/              # Data models (Player, Rookie, Battleground)
│   │   └── moves/          # Move system (AttackMove, EffectMove)
│   ├── resources/          # Text strings and ASCII art assets
│   └── utils/              # Utility classes (StringReader, SaveManager)
├── archive/                # Legacy versions
├── assets/                 # Asset folder
└── RRRPG.jar               # Latest playable version
```

## Patch notes
* **V0.2-alpha:** 2 new battlegrounds, 4 new unique enemies, health upgrade with balanced combat, shop added to game.
* **V0.1-alpha:** First playable version. 2 playable battlegrounds, 4 unique characters, 5 unique enemies, 15 different moves.

## Getting Started
### Prerequisites
- Java Development Kit (JDK) 8 or higher

### Installation
1. Download the Application.jar file.
2. Open your terminal and navigate to the directory containing the jar file.
3. Run the application using the following command:
```bash
java -jar Application.jar
```

# Development
This project started as a way to put my academic training into practice, specifically focusing on implementing a modular architecture and mastering software design patterns learned in school.