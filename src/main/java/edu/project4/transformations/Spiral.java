package edu.project4.transformations;

import edu.project4.Point;
import java.util.concurrent.ThreadLocalRandom;

@SuppressWarnings("MagicNumber")
public class Spiral implements Transformation {

    private final int red;
    private final int green;
    private final int blue;
    private final double[] affine;

    public Spiral() {
        red = ThreadLocalRandom.current().nextInt(0, 256);
        green = ThreadLocalRandom.current().nextInt(0, 256);
        blue = ThreadLocalRandom.current().nextInt(0, 256);
        affine = getAffine();
    }

    @Override
    public Point transform(Point point) {
        Point p = getAffineTransform(affine, point);
        double r = Math.sqrt(p.x() * p.x() + p.y() * p.y());
        double q = Math.atan(p.x() / p.y());
        double newX = (1 / r) * (Math.cos(q) + Math.sin(r)) - 0.5;
        double newY = (1 / r) * (Math.sin(q) - Math.cos(r)) + 0.5;
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
