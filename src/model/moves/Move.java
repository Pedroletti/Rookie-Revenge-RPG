package model.moves;

import java.io.Serializable;

public abstract class Move implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private MoveType type;

    public enum MoveType {
        ATTACK, POWERUP, WEAKEN
    }

    public enum TargetStat {
        SPEED, DEFENSE, ATTACK, NONE
    }

    public Move(String name, MoveType type) {
        this.name = name;
        this.type = type;
    }

    public String getName() { return name; }
    public MoveType getType() { return type; }
}