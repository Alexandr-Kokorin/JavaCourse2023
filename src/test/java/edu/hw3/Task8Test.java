package edu.hw3;

import edu.hw3.task8.BackwardIterator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DisplayName("TestBackwardIterator")
public class Task8Test {

    @Test
    @DisplayName("Test - \"List.of(1, 2, 3)\", expected - \"3 2 1\"")
    void backwardIteratorTest1() {
        BackwardIterator<Integer> iterator = new BackwardIterator<>(List.of(1, 2, 3));

        StringBuilder result = new StringBuilder();
        while (iterator.hasNext()) {
            result.append(iterator.next());
        }

        assertThat(result.toString()).isEqualTo("321");
    }

    @Test
    @DisplayName("Test - \"List.of('a','b','c')\", expected - \"'c' 'b' 'a'\"")
    void backwardIteratorTest2() {
        BackwardIterator<Character> iterator = new BackwardIterator<>(List.of('a','b','c'));

        StringBuilder result = new StringBuilder();
        while (iterator.hasNext()) {
            result.append(iterator.next());
        }

        assertThat(result.toString()).isEqualTo("cba");
    }
}
