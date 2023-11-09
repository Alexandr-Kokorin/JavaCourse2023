package edu.hw3;

import edu.hw3.task7.MyComparator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.Comparator;
import java.util.TreeMap;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DisplayName("TestMyComparator")
public class Task7Test {

    static Arguments[] myComparatorTestData() {
        return new Arguments[]{
            Arguments.of(
                null,
                "test"
            ),
            Arguments.of(
                "null",
                "test"
            )
        };
    }

    @ParameterizedTest
    @MethodSource("myComparatorTestData")
    void myComparator_ResultShouldBeTrue(String testKey, String testValue) {
        TreeMap<String, String> tree = new TreeMap<>(Comparator.nullsFirst(new MyComparator()));
        tree.put(testKey, testValue);

        boolean result = tree.containsKey(testKey);

        assertThat(result).isTrue();
    }
}
