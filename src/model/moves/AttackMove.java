package model.moves;

public class AttackMove extends Move {
    private int baseDamage;

    public AttackMove(String name, int baseDamage) {
        super(name, MoveType.ATTACK);
        this.baseDamage = baseDamage;
    }
    public AttackMove(String name, int baseDamage, int cost) {
        super(name, MoveType.ATTACK);
        this.baseDamage = baseDamage;
        this.cost = cost;
    }

    public int getBaseDamage() { return baseDamage; }
}