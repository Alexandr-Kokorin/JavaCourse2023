package edu.hw8.task2;

import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class FixedThreadPool implements ThreadPool {

    private final Thread[] threads;
    private final BlockingQueue<Runnable> queue;

    private FixedThreadPool(int n) {
        threads = new Thread[n];
        queue = new LinkedBlockingQueue<>();
    }

    public static FixedThreadPool create(int n) {
        return new FixedThreadPool(n);
    }

    @Override
    public void start() throws InterruptedException {
        while (!queue.isEmpty()) {
            for (int i = 0; i < threads.length; i++) {
                if (Objects.isNull(threads[i]) || !threads[i].isAlive()) {
                    threads[i] = new Thread(queue.take());
                    threads[i].start();
                }
            }
        }
    }

    @Override
    public void execute(Runnable runnable) {
        queue.add(runnable);
    }

    @Override
    public void close() throws Exception {}
}
