package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DisplayName("TestIsSubsequences")
public class Task6Test {

    static Arguments[] isSubsequencesTestData() {
        return new Arguments[]{
            Arguments.of(
                "abc",
                "achfdbaabgabcaabg",
                true
            ),
            Arguments.of(
                "abfg",
                "achfdbaabgabcaabg",
                false
            ),
            Arguments.of(
                "afcg",
                "achfdbaabgabcaabg",
                true
            ),
            Arguments.of(
                null,
                null,
                false
            )
        };
    }

    @ParameterizedTest
    @MethodSource("isSubsequencesTestData")
    void isSubsequences_ResultShouldMatchExpected(String subTest, String test, boolean expected) {
        boolean result = Task6.isSubsequences(subTest, test);

        assertThat(result).isEqualTo(expected);
    }
}
