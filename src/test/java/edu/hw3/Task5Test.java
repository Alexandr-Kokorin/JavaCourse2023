package edu.hw3;

import edu.hw3.task5.Contact;
import edu.hw3.task5.Direction;
import edu.hw3.task5.Task5;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.Arrays;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DisplayName("TestParseContacts")
public class Task5Test {

    static Arguments[] parseContactsTestData() {
        return new Arguments[] {
            Arguments.of(
                new String[]{"John Locke", "Thomas Aquinas", "David Hume", "Rene Descartes"},
                Direction.ASK,
                "[Thomas Aquinas, Rene Descartes, David Hume, John Locke]"
            ),
            Arguments.of(
                new String[]{"Paul Erdos", "Leonhard Euler", "Carl Gauss"},
                Direction.DESC,
                "[Carl Gauss, Leonhard Euler, Paul Erdos]"
            ),
            Arguments.of(
                new String[]{"Paul Erdos", "Leonhard Euler", "Carl"},
                Direction.DESC,
                "[Leonhard Euler, Paul Erdos, Carl]"
            ),
            Arguments.of(
                new String[]{},
                Direction.DESC,
                "[]"
            ),
            Arguments.of(
                null,
                Direction.DESC,
                "[]"
            )
        };
    }

    @ParameterizedTest
    @MethodSource("parseContactsTestData")
    void parseContacts_ResultShouldMatchExpected(String[] testNames, Direction testDirection, String expected) {
        Contact[] result = Task5.parseContacts(testNames, testDirection);

        assertThat(Arrays.toString(result)).isEqualTo(expected);
    }
}
