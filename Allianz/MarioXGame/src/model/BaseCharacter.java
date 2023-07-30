package model;

public class BaseCharacter {
    private String name;
    private Coordinate coordinate;

    public BaseCharacter(String name, Coordinate coordinate) {
        this.name = name;
        this.coordinate = coordinate;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "BaseCharacter{" +
                "name='" + name + '\'' +
                ", coordinate=" + coordinate +
                '}';
    }
}
