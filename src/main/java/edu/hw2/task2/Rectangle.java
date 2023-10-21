package edu.hw2.task2;

public class Rectangle {

    private int width;
    private int height;

    public Rectangle() {}

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public final Rectangle setSize(int width, int height) {
        return new Rectangle(width, height);
    }

    public double area() {
        return width * height;
    }
}
