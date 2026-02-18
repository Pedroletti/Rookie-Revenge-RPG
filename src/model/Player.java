package model;

import java.io.Serializable;

public class Player implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private Rookie rookie;
    private int gold;

    public Player(String name) {
        this.name = name;
        gold = 0;
    }

    public void setRookie(Rookie r) {
        this.rookie = r;
    }
    public String getName() {
        return name;
    }

    public Rookie getRookie() {
        return rookie;
    }

    public void setGold(int gold) { this.gold = gold; }
    public int getGold() { return gold; }
    public void addGold(int gold) { this.gold += gold; }
}
