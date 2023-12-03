package edu.hw8.task2;

import java.util.Objects;

public class FixedThreadPool implements ThreadPool {

    private final Thread[] threads;

    private FixedThreadPool(int n) {
        threads = new Thread[n];
    }

    public static FixedThreadPool create(int n) {
        return new FixedThreadPool(n);
    }

    @Override
    public void start() {
        for (Thread thread : threads) {
            if (!Objects.isNull(thread) && !thread.isAlive()) {
                thread.start();
            }
        }
    }

    @Override
    public void execute(Runnable runnable) {
        boolean flag = true;
        while (flag) {
            for (int i = 0; i < threads.length; i++) {
                if (Objects.isNull(threads[i])) {
                    threads[i] = new Thread(runnable);
                    threads[i].start();
                    flag = false;
                    break;
                } else if (!threads[i].isAlive()) {
                    threads[i] = null;
                }
            }
        }
    }

    @Override
    public void close() throws Exception {}
}
