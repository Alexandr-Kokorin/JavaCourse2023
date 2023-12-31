package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.time.LocalDate;
import java.util.Optional;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DisplayName("TestParseDate")
public class Task3Test {

    static Arguments[] parseDateTestData() {
        return new Arguments[]{
            Arguments.of(
                "2020-10-10",
                Optional.of(LocalDate.of(2020, 10, 10))
            ),
            Arguments.of(
                "2020-12-2",
                Optional.of(LocalDate.of(2020, 12, 2))
            ),
            Arguments.of(
                "1/3/1976",
                Optional.of(LocalDate.of(1976, 3, 1))
            ),
            Arguments.of(
                "1/3/20",
                Optional.of(LocalDate.of(2020, 3, 1))
            ),
            Arguments.of(
                "tomorrow",
                Optional.of(LocalDate.now().plusDays(1))
            ),
            Arguments.of(
                "today",
                Optional.of(LocalDate.now())
            ),
            Arguments.of(
                "yesterday",
                Optional.of(LocalDate.now().minusDays(1))
            ),
            Arguments.of(
                "1 day ago",
                Optional.of(LocalDate.now().minusDays(1))
            ),
            Arguments.of(
                "2234 days ago",
                Optional.of(LocalDate.now().minusDays(2234))
            ),
            Arguments.of(
                "23 day 2 month 123 year",
                Optional.empty()
            ),
            Arguments.of(
                "",
                Optional.empty()
            ),
            Arguments.of(
                null,
                Optional.empty()
            )
        };
    }

    @ParameterizedTest
    @MethodSource("parseDateTestData")
    @SuppressWarnings("OptionalUsedAsFieldOrParameterType")
    void parseDate_ResultShouldMatchExpected(String test, Optional<LocalDate> expected) {
        Optional<LocalDate> result = Task3.parseDate(test);

        assertThat(result).isEqualTo(expected);
    }
}
