package edu.hw8;

import edu.hw8.task2.FixedThreadPool;
import org.junit.jupiter.api.Test;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class FixedThreadPoolTest {

    @Test
    void fixedThreadPoolTest() throws InterruptedException {
        ConcurrentHashMap<Integer, Integer> map = new ConcurrentHashMap<>();
        FixedThreadPool fixedThreadPool = FixedThreadPool.create(2);
        fixedThreadPool.execute(() -> map.put(4, fib(4)));
        fixedThreadPool.execute(() -> map.put(5, fib(5)));
        fixedThreadPool.execute(() -> map.put(6, fib(6)));
        fixedThreadPool.execute(() -> map.put(7, fib(7)));
        fixedThreadPool.start();

        Thread.sleep(1000);
        assertThat(map).isEqualTo(Map.of(4, 3, 5, 5, 6, 8, 7, 13));
    }

    private int fib(int n) {
        if (n <= 2) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }
}
