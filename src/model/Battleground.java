package model;

import java.io.Serializable;
import java.util.List;
import java.util.Random;

public class Battleground implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private List<Rookie> enemies;
    private Random random;
    private boolean locked;
    private boolean gym;
    private boolean defeated;
    private int currentIndex = 0;

    public Battleground(String name, List<Rookie> enemies, boolean locked, boolean gym) {
        this.name = name;
        this.enemies = enemies;
        this.random = new Random();
        this.locked = locked;
        this.gym = gym;
        if(gym) defeated = false;
    }

    public Rookie getRandomOpponent() {
        int index = random.nextInt(enemies.size());
        Rookie enemy = enemies.get(index);
        return new Rookie(enemy);
    }

    public Rookie getNextOpponent() {
        if (enemies.isEmpty()) return null;
        return enemies.get(currentIndex);
    }

    public void registerGymVictory() {
        currentIndex++;
        if (currentIndex >= enemies.size()) {
            defeated = true;
        }
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public boolean isLocked() {
        return locked;
    }

    public boolean isGym() { return gym; }

    public boolean isDefeated() { return defeated; }
}
