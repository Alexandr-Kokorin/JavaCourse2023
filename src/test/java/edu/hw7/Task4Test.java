package edu.hw7;

import edu.hw7.task4.CalculationPI;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task4Test {

    static Arguments[] calculateSimpleTestData() {
        return new Arguments[]{
            Arguments.of(10000000),
            Arguments.of(100000000),
            Arguments.of(1000000000)
        };
    }

    @ParameterizedTest
    @MethodSource("calculateSimpleTestData")
    void calculateSimple_ResultShouldMatchExpected(long test) {
        long start = System.currentTimeMillis();
        var result = CalculationPI.calculateSimple(test);
        long end = System.currentTimeMillis();
        System.out.println(end - start + " ms, delta " + (float) Math.abs(result - Math.PI));

        double delta = 0.001;
        assertThat(result > Math.PI - delta && result < Math.PI + delta).isTrue();
    }

    static Arguments[] calculateMultithreadingTestData() {
        return new Arguments[]{
            Arguments.of(
                10000000,
                2
            ),
            Arguments.of(
                100000000,
                2
            ),
            Arguments.of(
                1000000000,
                2
            ),
            Arguments.of(
                10000000,
                4
            ),
            Arguments.of(
                100000000,
                4
            ),
            Arguments.of(
                1000000000,
                4
            ),
            Arguments.of(
                10000000,
                8
            ),
            Arguments.of(
                100000000,
                8
            ),
            Arguments.of(
                1000000000,
                8
            ),
            Arguments.of(
                10000000,
                16
            ),
            Arguments.of(
                100000000,
                16
            ),
            Arguments.of(
                1000000000,
                16
            )
        };
    }

    @ParameterizedTest
    @MethodSource("calculateMultithreadingTestData")
    void calculateMultithreading_ResultShouldMatchExpected(long test, int thread) throws InterruptedException {
        long start = System.currentTimeMillis();
        var result = CalculationPI.calculateMultithreading(test, thread);
        long end = System.currentTimeMillis();
        System.out.println(end - start + " ms, delta " + (float) Math.abs(result - Math.PI));

        double delta = 0.001;
        assertThat(result > Math.PI - delta && result < Math.PI + delta).isTrue();
    }
}
