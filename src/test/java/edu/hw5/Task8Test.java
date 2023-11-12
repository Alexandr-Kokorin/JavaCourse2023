package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DisplayName("TestTask8")
public class Task8Test {

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
        boolean result = Task8.regex1(test);

        assertThat(result).isEqualTo(expected);
    }

    static Arguments[] regex2TestData() {
        return new Arguments[]{
            Arguments.of(
                "010",
                true
            ),
            Arguments.of(
                "110011",
                true
            ),
            Arguments.of(
                "0011",
                false
            ),
            Arguments.of(
                "110",
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
    @MethodSource("regex2TestData")
    void regex2_ResultShouldMatchExpected(String test, boolean expected) {
        boolean result = Task8.regex2(test);

        assertThat(result).isEqualTo(expected);
    }

    static Arguments[] regex4TestData() {
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
                "11",
                false
            ),
            Arguments.of(
                "111",
                false
            ),
            Arguments.of(
                null,
                false
            )
        };
    }

    @ParameterizedTest
    @MethodSource("regex4TestData")
    void regex4_ResultShouldMatchExpected(String test, boolean expected) {
        boolean result = Task8.regex4(test);

        assertThat(result).isEqualTo(expected);
    }

    static Arguments[] regex5TestData() {
        return new Arguments[]{
            Arguments.of(
                "1010",
                true
            ),
            Arguments.of(
                "101",
                true
            ),
            Arguments.of(
                "011",
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
    @MethodSource("regex5TestData")
    void regex5_ResultShouldMatchExpected(String test, boolean expected) {
        boolean result = Task8.regex5(test);

        assertThat(result).isEqualTo(expected);
    }

    static Arguments[] regex7TestData() {
        return new Arguments[]{
            Arguments.of(
                "1010",
                true
            ),
            Arguments.of(
                "101",
                true
            ),
            Arguments.of(
                "0101",
                true
            ),
            Arguments.of(
                "100",
                true
            ),
            Arguments.of(
                "00",
                true
            ),
            Arguments.of(
                "11",
                false
            ),
            Arguments.of(
                "011",
                false
            ),
            Arguments.of(
                "0110",
                false
            ),
            Arguments.of(
                null,
                false
            )
        };
    }

    @ParameterizedTest
    @MethodSource("regex7TestData")
    void regex7_ResultShouldMatchExpected(String test, boolean expected) {
        boolean result = Task8.regex7(test);

        assertThat(result).isEqualTo(expected);
    }
}
