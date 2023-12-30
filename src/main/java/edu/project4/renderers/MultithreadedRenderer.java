package edu.project4.renderers;

import edu.project4.FractalImage;
import edu.project4.World;
import edu.project4.transformations.Transformation;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultithreadedRenderer implements Renderer {

    @Override
    public void render(FractalImage canvas, World world, List<Transformation> variations,
        int samples, short iterPerSample, int symmetry) {

        int cores = Runtime.getRuntime().availableProcessors();
        CountDownLatch latch = new CountDownLatch(cores);
        ExecutorService executorService = Executors.newFixedThreadPool(cores);
        for (int i = 0; i < cores; i++) {
            executorService.execute(() -> {
                localRender(canvas, world, variations, samples / cores, iterPerSample, symmetry);
                latch.countDown();
            });
        }
        try {
            latch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            executorService.close();
        }
    }
}
