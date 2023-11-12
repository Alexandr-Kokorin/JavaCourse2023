package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DisplayName("TestTask7")
public class Task7Test {

    static Arguments[] regex1TestData() {
        return new Arguments[]{
            Arguments.of(
                "010",
                true
            ),
            Arguments.of(
                "11010",
                true
            ),
            Arguments.of(
                "0010",
                false
            ),
            Arguments.of(
                "01",
                false
            ),
            Arguments.of(
                null,
                false
            )
        };
    }

    @ParameterizedTest
    @MethodSource("regex1TestData")
    void regex1_ResultShouldMatchExpected(String test, boolean expected) {
        boolean result = Task7.regex1(test);

        assertThat(result).isEqualTo(expected);
    }

    static Arguments[] regex2TestData() {
        return new Arguments[]{
            Arguments.of(
                "010",
                true
            ),
            Arguments.of(
                "11001",
                true
            ),
            Arguments.of(
                "0011",
                false
            ),
            Arguments.of(
                "01",
                false
            ),
            Arguments.of(
                null,
                false
            )
        };
    }

    @ParameterizedTest
    @MethodSource("regex2TestData")
    void regex2_ResultShouldMatchExpected(String test, boolean expected) {
        boolean result = Task7.regex2(test);

        assertThat(result).isEqualTo(expected);
    }

    static Arguments[] regex3TestData() {
        return new Arguments[]{
            Arguments.of(
                "010",
                true
            ),
            Arguments.of(
                "1",
                true
            ),
            Arguments.of(
                "0010",
                false
            ),
            Arguments.of(
                "",
                false
            ),
            Arguments.of(
                null,
                false
            )
        };
    }

    @ParameterizedTest
    @MethodSource("regex3TestData")
    void regex3_ResultShouldMatchExpected(String test, boolean expected) {
        boolean result = Task7.regex3(test);

        assertThat(result).isEqualTo(expected);
    }
}
