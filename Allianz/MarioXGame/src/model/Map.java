package model;

import java.util.ArrayList;
import java.util.Arrays;

public class Map {
    private String name;
    private int xLength;
    private int yLength;
    private ArrayList<Villain> villains = new ArrayList<>();
    private BaseCharacter[][] mapPlacement;

    public Map(String name, int xLength, int yLength) {
        this.name = name;
        this.xLength = xLength;
        this.yLength = yLength;
        mapPlacement = new BaseCharacter[yLength][xLength];

    }

    public ArrayList<Villain> getVillains() {
        return villains;
    }

    public void setVillains(ArrayList<Villain> villains) {
        this.villains = villains;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getXLength() {
        return xLength;
    }

    public void setXLength(int xLength) {
        this.xLength = xLength;
    }

    public int getYLength() {
        return yLength;
    }

    public void setYLength(int yLength) {
        this.yLength = yLength;
    }

    public BaseCharacter[][] getMapPlacement() {
        return mapPlacement;
    }

    public void setMapPlacement(BaseCharacter[][] mapPlacement) {
        this.mapPlacement = mapPlacement;
    }

    @Override
    public String toString() {
        return "Map{" +
                "name='" + name + '\'' +
                ", xLength=" + xLength +
                ", yLength=" + yLength +
                ", mapPlacement=" + Arrays.toString(mapPlacement) +
                '}';
    }
}
