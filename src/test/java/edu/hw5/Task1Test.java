package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.time.Duration;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DisplayName("TestAverageTime")
public class Task1Test {

    static Arguments[] averageTimeTestData() {
        return new Arguments[]{
            Arguments.of(
                new String[]{
                    "2022-03-12, 20:20 - 2022-03-12, 23:50",
                    "2022-04-01, 21:30 - 2022-04-02, 01:20"},
                Duration.ofMinutes(220)
            ),
            Arguments.of(
                new String[]{
                    "2022-03-12, 20:30 - 2022-03-12, 23:50",
                    "2022-04-01, 21:30 - 2022-04-02, 03:20",
                    "2022-04-01, 21:30 - 2022-04-02, 01:20"},
                Duration.ofMinutes(260)
            ),
            Arguments.of(
                new String[]{},
                null
            ),
            Arguments.of(
                null,
                null
            )
        };
    }

    @ParameterizedTest
    @MethodSource("averageTimeTestData")
    void averageTime_ResultShouldMatchExpected(String[] test, Duration expected) {
        Duration result = Task1.averageTime(test);

        assertThat(result).isEqualTo(expected);
    }
}
