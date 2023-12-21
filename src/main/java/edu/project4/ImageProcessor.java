package edu.project4;

public class ImageProcessor {

    private static final double GAMMA = 2.2;

    public void process(FractalImage image) {
        double max = 0;
        for (int row = 0; row < image.height(); row++) {
            for (int col = 0; col < image.width(); col++) {
                if (image.data()[row][col].getHitCount() != 0) {
                    image.data()[row][col].setNormal(Math.log10(image.data()[row][col].getHitCount()));
                    max = Math.max(max, image.data()[row][col].getNormal());
                }
            }
        }
        for (int row = 0; row < image.height(); row++) {
            for (int col = 0; col < image.width(); col++) {
                image.data()[row][col].setNormal(image.data()[row][col].getNormal() / max);
                image.data()[row][col].setRed(
                    (int) (image.data()[row][col].getRed()
                        * Math.pow(image.data()[row][col].getNormal(), (1 / GAMMA))));
                image.data()[row][col].setGreen(
                    (int) (image.data()[row][col].getGreen()
                        * Math.pow(image.data()[row][col].getNormal(), (1 / GAMMA))));
                image.data()[row][col].setBlue(
                    (int) (image.data()[row][col].getBlue()
                        * Math.pow(image.data()[row][col].getNormal(), (1 / GAMMA))));
            }
        }
    }
}
