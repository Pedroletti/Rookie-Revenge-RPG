package model.moves;

public class EffectMove extends Move {
    private TargetStat stat;
    private double multiplier;

    public EffectMove(String name, MoveType type, TargetStat stat, double multiplier) {
        super(name, type);
        this.stat = stat;
        this.multiplier = multiplier;
    }

    public EffectMove(String name, MoveType type, TargetStat stat, double multiplier, int cost) {
        super(name, type);
        this.stat = stat;
        this.multiplier = multiplier;
        this.cost = cost;
    }

    public TargetStat getStat() { return stat; }
    public double getMultiplier() { return multiplier; }
}