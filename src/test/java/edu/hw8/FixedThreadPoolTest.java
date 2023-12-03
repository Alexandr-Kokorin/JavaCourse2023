package edu.hw8;

import edu.hw8.task2.FixedThreadPool;
import org.junit.jupiter.api.Test;
import java.util.concurrent.atomic.AtomicInteger;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class FixedThreadPoolTest {

    @Test
    void fixedThreadPoolTest() throws InterruptedException {
        AtomicInteger number = new AtomicInteger();
        FixedThreadPool fixedThreadPool = FixedThreadPool.create(2);
        fixedThreadPool.start();
        fixedThreadPool.execute(number::incrementAndGet);
        fixedThreadPool.execute(number::incrementAndGet);
        fixedThreadPool.execute(number::incrementAndGet);
        fixedThreadPool.execute(number::incrementAndGet);

        Thread.sleep(1000);
        assertThat(number.get()).isEqualTo(4);
    }
}
