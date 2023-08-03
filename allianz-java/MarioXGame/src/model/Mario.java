package model;

public class Mario extends MarioBaseCharacter{
    public Mario(String name, int health, GrowthCycleEnum growthCycleEnum, int length, boolean immortality, int remainingLife, Coordinate coordinate) {
        super(name, health, growthCycleEnum, length, immortality, remainingLife, coordinate);
    }
}
