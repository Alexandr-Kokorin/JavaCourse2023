package edu.project4;

import edu.project4.renderers.MultithreadedRenderer;
import edu.project4.renderers.Renderer;
import edu.project4.renderers.SimpleRenderer;
import edu.project4.transformations.Handkerchief;
import edu.project4.transformations.Hyperbolic;
import edu.project4.transformations.Spherical;
import edu.project4.transformations.Spiral;
import edu.project4.transformations.Transformation;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.io.File;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class FlameTest {

    static Arguments[] renderers() {
        return new Arguments[]{
            Arguments.of(new SimpleRenderer()),
            Arguments.of(new MultithreadedRenderer())
        };
    }

    @ParameterizedTest
    @MethodSource("renderers")
    void flameTest(Renderer renderer) {
        FractalImage canvas = FractalImage.create(1920, 1080);
        World world = new World(-2, -2, 4, 4);
        List<Transformation> variations = List.of(new Handkerchief(), new Hyperbolic(), new Spherical(), new Spiral());
        long start = System.currentTimeMillis();
        renderer.render(canvas, world, variations, 200000, (short) 200, 4);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        ImageProcessor imageProcessor = new ImageProcessor();
        imageProcessor.process(canvas);
        ImageUtils imageUtils = new ImageUtils();
        imageUtils.save(canvas, "fractals" + File.separator + "fire", ImageFormat.PNG);

        assertThat(new File("fractals" + File.separator + "fire.png").exists()).isTrue();
    }
}
