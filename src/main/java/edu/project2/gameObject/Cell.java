package edu.project2.gameObject;

public class Cell {

    private final Coordinate coordinate;
    private Type type;

    public Cell(Coordinate coordinate, Type type) {
        this.coordinate = coordinate;
        this.type = type;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
