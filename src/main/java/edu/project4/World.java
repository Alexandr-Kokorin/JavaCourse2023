package edu.project4;

import java.util.concurrent.ThreadLocalRandom;

public record World(double x, double y, double width, double height) {

    public Point random() {
        double px = ThreadLocalRandom.current().nextDouble(x, width);
        double py = ThreadLocalRandom.current().nextDouble(y, height);
        return new Point(px, py);
    }

    public Point rotate(Point point, double theta2) {
        double px = point.x() * Math.cos(theta2) - point.y() * Math.sin(theta2);
        double py = point.x() * Math.sin(theta2) + point.y() * Math.cos(theta2);
        return new Point(px, py);
    }

    public boolean contains(Point p) {
        return p.x() >= x && p.x() <= width && p.y() >= y && p.y() <= width;
    }
}
