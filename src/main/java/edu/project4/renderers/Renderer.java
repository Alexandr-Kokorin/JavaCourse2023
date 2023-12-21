package edu.project4.renderers;

import edu.project4.FractalImage;
import edu.project4.Pixel;
import edu.project4.Point;
import edu.project4.World;
import edu.project4.transformations.Transformation;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

public interface Renderer {

    void render(FractalImage canvas, World world, List<Transformation> variations,
        int samples, short iterPerSample, int symmetry);

    default void localRender(FractalImage canvas, World world, List<Transformation> variations,
        int samples, short iterPerSample, int symmetry) {

        for (int num = 0; num < samples; num++) {
            Point point = world.random();

            for (short step = 0; step < iterPerSample; step++) {
                int index = ThreadLocalRandom.current().nextInt(0, variations.size());
                Transformation variation = variations.get(index);

                point = variation.transform(point);

                double theta2 = 0.0;
                for (int s = 0; s < symmetry; theta2 += Math.PI * 2 / symmetry, ++s) {
                    var pwr = world.rotate(point, theta2);
                    if (!world.contains(pwr)) {
                        continue;
                    }

                    Pixel pixel = canvas.pixel(world, pwr);
                    if (Objects.isNull(pixel)) {
                        continue;
                    }

                    synchronized (pixel) {
                        pixel.mixColor(variation.getRed(), variation.getGreen(), variation.getBlue());
                        pixel.incHitCount();
                    }
                }
            }
        }
    }
}
