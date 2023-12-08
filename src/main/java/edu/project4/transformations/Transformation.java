package edu.project4.transformations;

import edu.project4.Point;
import java.util.concurrent.ThreadLocalRandom;

@SuppressWarnings("MagicNumber")
public interface Transformation {

    Point transform(Point point);

    int getRed();

    int getGreen();

    int getBlue();

    default double[] getAffine() {
        double[] affine = new double[6];
        for (int i = 0; i < affine.length; i++) {
            if (i != 2 && i != 5) {
                affine[i] = ThreadLocalRandom.current().nextDouble(0, 1.5);
            } else {
                affine[i] = ThreadLocalRandom.current().nextDouble(-0.8, 0.8);
            }
        }
        return affine;
    }

    default Point getAffineTransform(double[] affine, Point point) {
        double x = affine[0] * point.x() + affine[1] * point.y() + affine[2];
        double y = affine[3] * point.x() + affine[4] * point.y() + affine[5];
        return new Point(x, y);
    }
}
