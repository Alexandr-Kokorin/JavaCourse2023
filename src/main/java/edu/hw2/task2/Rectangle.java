package edu.hw2.task2;

public class Rectangle {

    private int width;
    private int height;

    public final void setWidth(int width) {
        this.width = width;
    }

    public final void setHeight(int height) {
        this.height = height;
    }

    public double area() {
        return width * height;
    }
}
