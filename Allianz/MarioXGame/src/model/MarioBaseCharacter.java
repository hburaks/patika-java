package model;

public class MarioBaseCharacter extends BaseCharacter {
    private int health;
    private GrowthCycleEnum growthCycleEnum;
    private int length;
    private boolean immortality;
    private int remainingLife;

    private Coordinate coordinate;


    public MarioBaseCharacter(String name, int health, GrowthCycleEnum growthCycleEnum, int length, boolean immortality, int remainingLife, Coordinate coordinate) {
        super(name);
        this.health = health;
        this.growthCycleEnum = growthCycleEnum;
        this.length = length;
        this.immortality = immortality;
        this.remainingLife = remainingLife;
        this.coordinate = coordinate;
    }
    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public GrowthCycleEnum getGrowthCycleEnum() {
        return growthCycleEnum;
    }

    public void setGrowthCycleEnum(GrowthCycleEnum growthCycleEnum) {
        this.growthCycleEnum = growthCycleEnum;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public boolean isImmortality() {
        return immortality;
    }

    public void setImmortality(boolean immortality) {
        this.immortality = immortality;
    }

    public int getRemainingLife() {
        return remainingLife;
    }

    public void setRemainingLife(int remainingLife) {
        this.remainingLife = remainingLife;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    @Override
    public String toString() {
        return "MarioBaseCharacter{" +
                ", health=" + health +
                ", growthCycleEnum=" + growthCycleEnum +
                ", length=" + length +
                ", immortality=" + immortality +
                ", remainingLife=" + remainingLife +
                '}';
    }
}
