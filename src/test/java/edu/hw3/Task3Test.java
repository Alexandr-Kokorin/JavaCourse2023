package edu.hw3;

import edu.hw3.task3.Task3;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DisplayName("TestFreqDict")
public class Task3Test {

    @Test
    @DisplayName("Test - \"[\"a\", \"bb\", \"a\", \"bb\"]\", expected - \"{\"bb\": 2, \"a\": 2}\"")
    void freqDictTest1() {
        List<String> list = Arrays.asList("a", "bb", "a", "bb");

        Map<String, Integer> result = Task3.freqDict(list);

        assertThat(result).isEqualTo(Map.of("bb", 2, "a", 2));
    }

    @Test
    @DisplayName("Test - \"[\"this\", \"and\", \"that\", \"and\"]\", expected - \"{\"that\": 1, \"and\": 2, \"this\": 1}\"")
    void freqDictTest2() {
        List<String> list = Arrays.asList("this", "and", "that", "and");

        Map<String, Integer> result = Task3.freqDict(list);

        assertThat(result).isEqualTo(Map.of("that", 1, "and", 2, "this", 1));
    }

    @Test
    @DisplayName("Test - \"[\"код\", \"код\", \"код\", \"bug\"]\", expected - \"{\"код\": 3, \"bug\": 1}\"")
    void freqDictTest3() {
        List<String> list = Arrays.asList("код", "код", "код", "bug");

        Map<String, Integer> result = Task3.freqDict(list);

        assertThat(result).isEqualTo(Map.of("код", 3, "bug", 1));
    }

    @Test
    @DisplayName("Test - \"[1, 1, 2, 2]\", expected - \"{1: 2, 2: 2}\"")
    void freqDictTest4() {
        List<Integer> list = Arrays.asList(1, 1, 2, 2);

        Map<Integer, Integer> result = Task3.freqDict(list);

        assertThat(result).isEqualTo(Map.of(1, 2, 2, 2));
    }

    @Test
    @DisplayName("Test - \"[]\", expected - \"{}\"")
    void freqDictTest5() {
        List<String> list = List.of();

        Map<String, Integer> result = Task3.freqDict(list);

        assertThat(result).isEqualTo(Map.of());
    }

    @Test
    @DisplayName("Test - \"null\", expected - \"{}\"")
    void freqDictTest6() {
        List<String> list = null;

        Map<String, Integer> result = Task3.freqDict(list);

        assertThat(result).isEqualTo(Map.of());
    }
}
