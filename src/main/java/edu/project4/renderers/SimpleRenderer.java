package edu.project4.renderers;

import edu.project4.FractalImage;
import edu.project4.World;
import edu.project4.transformations.Transformation;
import java.util.List;

public class SimpleRenderer implements Renderer {

    @Override
    public void render(FractalImage canvas, World world, List<Transformation> variations,
                       int samples, short iterPerSample, int symmetry) {

        localRender(canvas, world, variations, samples, iterPerSample, symmetry);
    }
}
