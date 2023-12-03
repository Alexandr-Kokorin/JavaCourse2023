package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.time.LocalDate;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DisplayName("TestFriday13")
public class Task2Test {

    static Arguments[] allFridays13TestData() {
        return new Arguments[]{
            Arguments.of(
                1925,
                List.of(LocalDate.parse("1925-02-13"), LocalDate.parse("1925-03-13"), LocalDate.parse("1925-11-13"))
            ),
            Arguments.of(
                2024,
                List.of(LocalDate.parse("2024-09-13"), LocalDate.parse("2024-12-13"))
            ),
            Arguments.of(
                956,
                List.of(LocalDate.parse("0956-02-13"), LocalDate.parse("0956-08-13"))
            )
        };
    }

    @ParameterizedTest
    @MethodSource("allFridays13TestData")
    void allFridays13_ResultShouldMatchExpected(int test, List<LocalDate> expected) {
        List<LocalDate> result = Task2.allFridays13(test);

        assertThat(result).isEqualTo(expected);
    }

    static Arguments[] friday13TestData() {
        return new Arguments[]{
            Arguments.of(
                LocalDate.parse("1925-02-05"),
                LocalDate.parse("1925-02-13")
            ),
            Arguments.of(
                LocalDate.parse("1925-02-15"),
                LocalDate.parse("1925-03-13")
            ),
            Arguments.of(
                null,
                null
            )
        };
    }

    @ParameterizedTest
    @MethodSource("friday13TestData")
    void friday13_ResultShouldMatchExpected(LocalDate test, LocalDate expected) {
        LocalDate result = Task2.nextFriday13(test);

        assertThat(result).isEqualTo(expected);
    }
}
