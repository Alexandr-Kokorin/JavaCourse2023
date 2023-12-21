package edu.project4.transformations;

import edu.project4.Point;
import java.util.concurrent.ThreadLocalRandom;

@SuppressWarnings("MagicNumber")
public class Hyperbolic implements Transformation {

    private final int red;
    private final int green;
    private final int blue;
    private final double[] affine;

    public Hyperbolic() {
        red = ThreadLocalRandom.current().nextInt(0, 256);
        green = ThreadLocalRandom.current().nextInt(0, 256);
        blue = ThreadLocalRandom.current().nextInt(0, 256);
        affine = getAffine();
    }

    @Override
    public Point transform(Point point) {
        Point p = getAffineTransform(affine, point);
        double r = Math.sqrt(p.x() * p.x() + p.y() * p.y());
        double q = Math.atan(p.x() / p.y()) * 2;
        double newX = Math.sin(q) / r;
        double newY = Math.cos(q) * r;
        return new Point(newX, newY);
    }

    @Override
    public int getRed() {
        return red;
    }

    @Override
    public int getGreen() {
        return green;
    }

    @Override
    public int getBlue() {
        return blue;
    }
}
