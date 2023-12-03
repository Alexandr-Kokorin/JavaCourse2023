package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DisplayName("TestIsCorrectLicensePlate")
public class Task5Test {

    static Arguments[] isCorrectLicensePlateTestData() {
        return new Arguments[]{
            Arguments.of(
                "А123ВЕ777",
                true
            ),
            Arguments.of(
                "О777ОО177",
                true
            ),
            Arguments.of(
                "123АВЕ777",
                false
            ),
            Arguments.of(
                "А123ВГ77",
                false
            ),
            Arguments.of(
                "А123ВЕ7777",
                false
            ),
            Arguments.of(
                "АА231К231",
                false
            ),
            Arguments.of(
                null,
                false
            )
        };
    }

    @ParameterizedTest
    @MethodSource("isCorrectLicensePlateTestData")
    void isCorrectLicensePlate_ResultShouldMatchExpected(String test, boolean expected) {
        boolean result = Task5.isCorrectLicensePlate(test);

        assertThat(result).isEqualTo(expected);
    }
}
