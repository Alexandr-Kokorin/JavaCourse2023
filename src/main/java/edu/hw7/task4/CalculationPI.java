package edu.hw7.task4;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicLong;

public final class CalculationPI {

    private CalculationPI() {}

    private static final double RADIUS = 0.5;
    private static final int MULTI = 4;

    public static double calculateSimple(long totalCount) {
        long circleCount = 0;
        for (long i = 0; i < totalCount; i++) {
            double x = ThreadLocalRandom.current().nextDouble();
            double y = ThreadLocalRandom.current().nextDouble();
            if (Math.pow(x - RADIUS, 2) + Math.pow(y - RADIUS, 2) <= Math.pow(RADIUS, 2)) {
                circleCount++;
            }
        }
        return MULTI * ((double) circleCount / totalCount);
    }

    public static double calculateMultithreading(long totalCount, int threadCount) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(threadCount);
        AtomicLong circleCount = new AtomicLong();
        for (int i = 0; i < threadCount; i++) {
            new Thread(() -> {
                long count = 0;
                for (long j = 0; j < totalCount / threadCount; j++) {
                    double x = ThreadLocalRandom.current().nextDouble();
                    double y = ThreadLocalRandom.current().nextDouble();
                    if (Math.pow(x - RADIUS, 2) + Math.pow(y - RADIUS, 2) <= Math.pow(RADIUS, 2)) {
                        count++;
                    }
                }
                circleCount.addAndGet(count);
                latch.countDown();
            }).start();
        }
        latch.await();
        return MULTI * ((double) circleCount.get() / totalCount);
    }
}
