package edu.hw7;

import edu.hw7.task1.Task1;
import org.junit.jupiter.api.Test;
import java.util.concurrent.CountDownLatch;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task1Test {

    @Test
    void incrementInEightThreadsTest() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(8);

        for (int i = 0; i < 8; i++) {
            new Thread(() -> {
                for (int j = 0; j < 5000; j++) {
                    Task1.increment();
                }
                latch.countDown();
            }).start();
        }

        latch.await();

        assertThat(Task1.getNumber()).isEqualTo(40000);
    }
}
