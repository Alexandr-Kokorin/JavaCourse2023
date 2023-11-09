package edu.hw3;

import edu.hw3.task2.Task2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DisplayName("TestClusterize")
public class Task2Test {

    static Arguments[] clusterizeTestData() {
        return new Arguments[] {
            Arguments.of(
                "()()()",
                new String[]{"()", "()", "()"}
            ),
            Arguments.of(
                "((()))",
                new String[]{"((()))"}
            ),
            Arguments.of(
                "((()))(())()()(()())",
                new String[]{"((()))", "(())", "()", "()", "(()())"}
            ),
            Arguments.of(
                "((())())(()(()()))",
                new String[]{"((())())", "(()(()()))"}
            ),
            Arguments.of(
                "())",
                new String[]{"()"}
            ),
            Arguments.of(
                null,
                new String[]{}
            )
        };
    }

    @ParameterizedTest
    @MethodSource("clusterizeTestData")
    void clusterize_ResultShouldMatchExpected(String test, String[] expected) {
        String[] result = Task2.clusterize(test);

        assertThat(result).isEqualTo(expected);
    }
}
