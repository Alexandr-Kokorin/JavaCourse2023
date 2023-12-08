package edu.project4;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImageUtils {

    public void save(FractalImage image, String filename, ImageFormat format) {
        BufferedImage bufferedImage = new BufferedImage(image.width(), image.height(), BufferedImage.TYPE_INT_RGB);
        for (int i = 0; i < image.width(); i++) {
            for (int j = 0; j < image.height(); j++) {
                bufferedImage.setRGB(i, j,
                    new Color(
                        image.data()[j][i].getRed(),
                        image.data()[j][i].getGreen(),
                        image.data()[j][i].getBlue()
                    ).getRGB()
                );
            }
        }
        String str = switch (format) {
            case PNG -> "png";
            case JPEG -> "jpeg";
            case BMP -> "bmp";
        };
        File file = new File(filename + '.' + str);
        try {
            ImageIO.write(bufferedImage, str, file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
