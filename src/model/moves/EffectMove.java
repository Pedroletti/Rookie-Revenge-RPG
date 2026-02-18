package model.moves;

public class EffectMove extends Move {
    private TargetStat stat;
    private int effectValue;

    public EffectMove(String name, MoveType type, TargetStat stat, int effectValue) {
        super(name, type);
        this.stat = stat;
        this.effectValue = effectValue;
    }

    public TargetStat getStat() { return stat; }
    public int getMultiplier() { return effectValue; }
}