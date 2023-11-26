package edu.hw7;

import edu.hw7.task2.Task2;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.math.BigInteger;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task2Test {

    static Arguments[] factorialTestData() {
        return new Arguments[]{
            Arguments.of(
                1,
                BigInteger.valueOf(1)
            ),
            Arguments.of(
                5,
                BigInteger.valueOf(120)
            ),
            Arguments.of(
                10,
                BigInteger.valueOf(3628800)
            )
        };
    }

    @ParameterizedTest
    @MethodSource("factorialTestData")
    void factorial_ResultShouldMatchExpected(int test, BigInteger expected) {
        var result = Task2.factorial(test);

        assertThat(result).isEqualTo(expected);
    }
}
