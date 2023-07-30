package model;

public class Villain extends BaseCharacter {
    private int damage;
    private boolean isMortal;
    private int health;
    private MoveTypeEnum moveTypeEnum;

    public Villain(String name, int damage, boolean isMortal, int health, MoveTypeEnum moveTypeEnum, Coordinate coordinate) {
        super(name, coordinate);
        this.damage = damage;
        this.isMortal = isMortal;
        this.health = health;
        this.moveTypeEnum = moveTypeEnum;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public boolean isMortal() {
        return isMortal;
    }

    public void setMortal(boolean mortal) {
        isMortal = mortal;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public MoveTypeEnum getMoveTypeEnum() {
        return moveTypeEnum;
    }

    public void setMoveTypeEnum(MoveTypeEnum moveTypeEnum) {
        this.moveTypeEnum = moveTypeEnum;
    }


    @Override
    public String toString() {
        return "Villain{" +
                "name=" + super.getName() +
                ", damage=" + damage +
                ", isMortal=" + isMortal +
                ", health=" + health +
                ", moveTypeEnum=" + moveTypeEnum +
                '}';
    }
}
