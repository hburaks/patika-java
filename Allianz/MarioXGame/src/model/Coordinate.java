package model;

public class Coordinate {
    private int xAxis;
    private int yAxis;

    public Coordinate(int xAxis, int yAxis) {
        this.xAxis = xAxis;
        this.yAxis = yAxis;
    }

    public int getxAxis() {
        return xAxis;
    }

    public void setxAxis(int xAxis) {
        this.xAxis = xAxis;
    }

    public int getyAxis() {
        return yAxis;
    }

    public void setyAxis(int yAxis) {
        this.yAxis = yAxis;
    }

    @Override
    public String toString() {
        return "Coordinate{ " +
                "xAxis = " + xAxis +
                ", yAxis = " + yAxis +
                " }";
    }
}
