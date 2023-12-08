package edu.project4;

import edu.project4.renderers.MultithreadedRenderer;
import edu.project4.renderers.Renderer;
import edu.project4.transformations.Handkerchief;
import edu.project4.transformations.Hyperbolic;
import edu.project4.transformations.Spherical;
import edu.project4.transformations.Spiral;
import edu.project4.transformations.Transformation;
import java.io.File;
import java.util.List;

public final class Main {

    private Main() {}

    @SuppressWarnings("MagicNumber")
    public static void main(String[] args) {
        FractalImage canvas = FractalImage.create(1920, 1080);
        World world = new World(-2, -2, 4, 4);
        List<Transformation> variations = List.of(new Handkerchief(), new Hyperbolic(), new Spherical(), new Spiral());
        Renderer renderer = new MultithreadedRenderer();
        renderer.render(canvas, world, variations, 200000, (short) 200, 4);
        ImageProcessor imageProcessor = new ImageProcessor();
        imageProcessor.process(canvas);
        ImageUtils imageUtils = new ImageUtils();
        imageUtils.save(canvas, "fractals" + File.separator + "fire", ImageFormat.PNG);
    }
}
