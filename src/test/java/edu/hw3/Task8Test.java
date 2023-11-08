package edu.hw3;

import edu.hw3.task5.Direction;
import edu.hw3.task8.BackwardIterator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DisplayName("TestBackwardIterator")
public class Task8Test {

    static Arguments[] backwardIteratorTestData() {
        return new Arguments[]{
            Arguments.of(
                List.of(1, 2, 3),
                "321"
            ),
            Arguments.of(
                List.of('a','b','c'),
                "cba"
            )
        };
    }

    @ParameterizedTest
    @MethodSource("backwardIteratorTestData")
    void backwardIterator_ResultShouldMatchExpected(List<? super Object> test, String expected) {
        BackwardIterator<? super Object> iterator = new BackwardIterator<>(test);

        StringBuilder result = new StringBuilder();
        while (iterator.hasNext()) {
            result.append(iterator.next());
        }

        assertThat(result.toString()).isEqualTo(expected);
    }
}
