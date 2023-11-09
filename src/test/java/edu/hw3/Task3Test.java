package edu.hw3;

import edu.hw3.task3.Task3;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DisplayName("TestFreqDict")
public class Task3Test {

    static Arguments[] freqDictTestData() {
        return new Arguments[] {
            Arguments.of(
                Arrays.asList("a", "bb", "a", "bb"),
                Map.of("bb", 2L, "a", 2L)
            ),
            Arguments.of(
                Arrays.asList("this", "and", "that", "and"),
                Map.of("that", 1L, "and", 2L, "this", 1L)
            ),
            Arguments.of(
                Arrays.asList("код", "код", "код", "bug"),
                Map.of("код", 3L, "bug", 1L)
            ),
            Arguments.of(
                Arrays.asList(1, 1, 2, 2),
                Map.of(1, 2L, 2, 2L)
            ),
            Arguments.of(
                List.of(),
                Map.of()
            ),
            Arguments.of(
                null,
                Map.of()
            )
        };
    }

    @ParameterizedTest
    @MethodSource("freqDictTestData")
    void freqDict_ResultShouldMatchExpected(List<? super Object> test, Map<? super Object, Long> expected) {
        Map<? super Object, Long> result = Task3.freqDict(test);

        assertThat(result).isEqualTo(expected);
    }
}
