package edu.hw7.task1;

import java.util.concurrent.atomic.AtomicLong;

public final class Task1 {

    private Task1() {}

    private static final AtomicLong NUMBER = new AtomicLong();

    public static void increment() {
        NUMBER.incrementAndGet();
    }

    public static long getNumber() {
        return NUMBER.get();
    }
}
