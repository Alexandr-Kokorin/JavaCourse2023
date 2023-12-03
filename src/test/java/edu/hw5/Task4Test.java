package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DisplayName("TestIsPasswordSecure")
public class Task4Test {

    static Arguments[] isPasswordSecureTestData() {
        return new Arguments[]{
            Arguments.of(
                "qwerty",
                false
            ),
            Arguments.of(
                "qwer+ty",
                false
            ),
            Arguments.of(
                "qwerty$",
                true
            ),
            Arguments.of(
                "qw|rty",
                true
            ),
            Arguments.of(
                "@qwerty",
                true
            ),
            Arguments.of(
                "q#er@ty$",
                true
            ),
            Arguments.of(
                "@#$",
                true
            ),
            Arguments.of(
                null,
                false
            )
        };
    }

    @ParameterizedTest
    @MethodSource("isPasswordSecureTestData")
    void isPasswordSecure_ResultShouldMatchExpected(String test, boolean expected) {
        boolean result = Task4.isPasswordSecure(test);

        assertThat(result).isEqualTo(expected);
    }
}
