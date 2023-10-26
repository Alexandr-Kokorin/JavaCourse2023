package edu.hw3;

import edu.hw3.task7.MyComparator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Comparator;
import java.util.TreeMap;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DisplayName("TestMyComparator")
public class Task7Test {

    @Test
    @DisplayName("Test - \"null, \"test\"\", expected - \"null\"")
    void myComparatorTest1() {
        TreeMap<String, String> tree = new TreeMap<>(Comparator.nullsFirst(new MyComparator()));
        tree.put(null, "test");

        boolean result = tree.containsKey(null);

        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("Test - \"'null', \"test\"\", expected - \"'null'\"")
    void myComparatorTest2() {
        TreeMap<String, String> tree = new TreeMap<>(Comparator.nullsFirst(new MyComparator()));
        tree.put("null", "test");

        boolean result = tree.containsKey("null");

        assertThat(result).isTrue();
    }
}
