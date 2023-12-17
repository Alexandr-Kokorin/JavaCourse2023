package edu.hw8.task2;

public interface ThreadPool extends AutoCloseable {

    void start() throws InterruptedException;

    void execute(Runnable runnable);
}
