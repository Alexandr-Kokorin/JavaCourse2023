package edu.hw3;

import edu.hw3.task5.Contact;
import edu.hw3.task5.Task5;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DisplayName("TestParseContacts")
public class Task5Test {

    @Test
    @DisplayName("Test - \"[\"John Locke\", \"Thomas Aquinas\", \"David Hume\", \"Rene Descartes\"]\", expected - \"[\"Thomas Aquinas\", \"Rene Descartes\", \"David Hume\", \"John Locke\"]\"")
    void parseContactsTest1() {
        String[] names = {"John Locke", "Thomas Aquinas", "David Hume", "Rene Descartes"};
        String direction = "ASC";

        Contact[] result = Task5.parseContacts(names, direction);

        assertThat(Arrays.toString(result)).isEqualTo("[Thomas Aquinas, Rene Descartes, David Hume, John Locke]");
    }

    @Test
    @DisplayName("Test - \"[\"Paul Erdos\", \"Leonhard Euler\", \"Carl Gauss\"]\", expected - \"[\"Carl Gauss\", \"Leonhard Euler\", \"Paul Erdos\"]\"")
    void parseContactsTest2() {
        String[] names = {"Paul Erdos", "Leonhard Euler", "Carl Gauss"};
        String direction = "DESC";

        Contact[] result = Task5.parseContacts(names, direction);

        assertThat(Arrays.toString(result)).isEqualTo("[Carl Gauss, Leonhard Euler, Paul Erdos]");
    }

    @Test
    @DisplayName("Test - \"[\"Paul Erdos\", \"Leonhard Euler\", \"Carl\"]\", expected - \"[\"Leonhard Euler\", \"Paul Erdos\", \"Carl\"]\"")
    void parseContactsTest3() {
        String[] names = {"Paul Erdos", "Leonhard Euler", "Carl"};
        String direction = "DESC";

        Contact[] result = Task5.parseContacts(names, direction);

        assertThat(Arrays.toString(result)).isEqualTo("[Leonhard Euler, Paul Erdos, Carl]");
    }

    @Test
    @DisplayName("Test - \"[]\", expected - \"[]\"")
    void parseContactsTest4() {
        String[] names = {};
        String direction = "DESC";

        Contact[] result = Task5.parseContacts(names, direction);

        assertThat(Arrays.toString(result)).isEqualTo("[]");
    }

    @Test
    @DisplayName("Test - \"null\", expected - \"[]\"")
    void parseContactsTest5() {
        String[] names = null;
        String direction = "DESC";

        Contact[] result = Task5.parseContacts(names, direction);

        assertThat(Arrays.toString(result)).isEqualTo("[]");
    }
}
