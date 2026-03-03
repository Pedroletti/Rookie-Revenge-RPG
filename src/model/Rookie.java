package model;
import model.moves.Move;

import javax.swing.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Rookie implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    int health = 50;
    int currentHealth = 50;
    int attack = 15;
    int defense = 15;
    int speed = 15;
    int level = 1;
    int experience = 0;
    int levelExperience = 10;
    int giveExperience = 10;
    int giveGold = 10;
    private List<Move> moves;
    private String asciiArt;
    private int mainStat;
    private String[] message;
    private boolean hasMsg;


    public Rookie(String name) {
        this.name = name.toUpperCase();
        moves = new ArrayList<>();
        Random rand = new Random();
        this.mainStat = rand.nextInt(4);
        this.message = null;
        getRandomStats();
        hasMsg = false;
    }

    public Rookie(Rookie other) {
        this.name = other.name;
        this.health = other.health;
        this.currentHealth = other.currentHealth;
        this.level = other.level;
        this.attack = other.attack;
        this.defense = other.defense;
        this.speed = other.speed;
        this.levelExperience = other.levelExperience;
        this.giveExperience = other.giveExperience;
        this.giveGold = other.giveGold;
        this.moves = other.moves;
        this.asciiArt = other.asciiArt;
    }

    private void getRandomStats () {
        java.util.Random rand = new java.util.Random();

        this.attack += rand.nextInt(4) + 1;
        this.defense += rand.nextInt(4) + 1;
        this.speed  += rand.nextInt(4) + 1;

        this.currentHealth = this.health;
    }

    private void upgradeStats() {
        switch (mainStat) {
            case 0:
                this.health += 1;
                break;
            case 1:
                this.attack += 1;
                break;
            case 2:
                this.defense += 1;
                break;
            case 3:
                this.speed += 1;
                break;
        }

        this.health += 3;
        this.attack += 2;
        this.defense += 2;
        this.speed += 2;
        this.currentHealth = this.health;
    }

    public void setArt(String art) { this.asciiArt = art; }

    public String getArt() { return this.asciiArt; }

    public String getName() { return name; }

    public String getCurrentHealth() { return "HEALTH: " + currentHealth; }

    public String getLevelString() { return "[L:" + level + "]"; }

    public int getLevel() { return level; }

    public void setHealth(int health) {
        this.health = health;
        this.currentHealth = health;
    }

    public void setAttack(int attack) { this.attack = attack; }

    public int getAttack() { return attack; }

    public void setDefense(int defense) { this.defense = defense; }

    public int getDefense() { return defense; }

    public void setSpeed(int speed) { this.speed = speed; }

    public int getSpeed() { return speed; }

    public void addMove(Move move) { moves.add(move); }

    public List<Move> getMoves() { return moves; }

    public void setMove(Move move, int index) { moves.set(index, move); }

    public void takeDamage(int damage) { this.currentHealth -= damage; }

    public int getHp() { return this.currentHealth; }

    public int getGiveExperience() { return this.giveExperience; }

    public int getGold() { return this.giveGold; }

    public void addExperience(int experience, JTextArea display) {
        while (true) {
            if (this.experience + experience > this.levelExperience) {
                experience = this.experience + experience - this.levelExperience;
                this.levelUp(1);
                display.append("\n " + this.name + " has reached level " + this.level + "!");
                this.experience = 0;
            }
            else {
                this.experience = this.experience + experience;
                break;
            }
        }
    }

    public void levelUp(int levelsToGain) {
        for (int i = 0; i < levelsToGain; i++) {
            if (this.level >= 100) break;

            this.level++;

            int expIncrease = calculateExpGain();
            this.levelExperience += expIncrease;
            int giveExpIncrease = (int)Math.round(expIncrease / 1.7);
            this.giveExperience += giveExpIncrease;
            int giveGoldIncrease = expIncrease * 2;
            this.giveGold += giveGoldIncrease;

            upgradeStats();
        }
    }

    private int calculateExpGain() {
        if (this.level > 50) return 30;
        if (this.level > 45) return 26;
        if (this.level > 40) return 22;
        if (this.level > 35) return 20;
        if (this.level > 30) return 18;
        if (this.level > 25) return 14;
        if (this.level > 10) return 8;
        if (this.level > 5) return 4;
        return 2;
    }

    public String getStats() {
        return " Level: " + this.level +
                "\n Experience: " + this.experience + "/" + this.levelExperience +
                "\n Health: " + this.currentHealth +
                "\n Attack: " + this.attack +
                "\n Defense: " + this.defense +
                "\n Speed: " + this.speed +
                getMainStat();
    }

    private String getMainStat() {
        return switch (mainStat) {
            case 0 -> "\n Main Stat: Health";
            case 1 -> "\n Main Stat: Attack";
            case 2 -> "\n Main Stat: Defense";
            case 3 -> "\n Main Stat: Speed";
            default -> "\n Main Stat: Unknown";
        };
    }

    public void setMessage(String[] message) {
        this.message = message;
        this.hasMsg = true;
    }

    public boolean hasMessage() { return hasMsg; }

    public void toggleMessage() { this.hasMsg = !this.hasMsg; }

    public String[] getMessage() {
        return this.message;
    }
}
