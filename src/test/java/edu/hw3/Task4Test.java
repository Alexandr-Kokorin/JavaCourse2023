package edu.hw3;

import edu.hw3.task4.Task4;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DisplayName("TestConvertToRoman")
public class Task4Test {

    static Arguments[] convertToRomanTestData() {
        return new Arguments[] {
            Arguments.of(
                2,
                "II"
            ),
            Arguments.of(
                12,
                "XII"
            ),
            Arguments.of(
                16,
                "XVI"
            ),
            Arguments.of(
                2017,
                "MMXVII"
            ),
            Arguments.of(
                -2,
                ""
            )
        };
    }

    @ParameterizedTest
    @MethodSource("convertToRomanTestData")
    void convertToRoman_ResultShouldMatchExpected(int test, String expected) {
        String result = Task4.convertToRoman(test);

        assertThat(result).isEqualTo(expected);
    }
}
