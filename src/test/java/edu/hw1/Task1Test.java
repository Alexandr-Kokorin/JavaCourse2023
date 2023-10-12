package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DisplayName("TestParseTime")
public class Task1Test {

    @Test
    @DisplayName("Test - \"13:56\", expected - \"836\"")
    void parseTimeTest1() {
        String time = "13:56";

        int seconds = Task1.minutesToSeconds(time);

        assertThat(seconds).isEqualTo(836);
    }

    @Test
    @DisplayName("Test - \"01:00\", expected - \"60\"")
    void parseTimeTest2() {
        String time = "01:00";

        int seconds = Task1.minutesToSeconds(time);

        assertThat(seconds).isEqualTo(60);
    }

    @Test
    @DisplayName("Test - \"10:60\", expected - \"-1\"")
    void parseTimeTest3() {
        String time = "10:60";

        int seconds = Task1.minutesToSeconds(time);

        assertThat(seconds).isEqualTo(-1);
    }

    @Test
    @DisplayName("Test - \"10:-50\", expected - \"-1\"")
    void parseTimeTest4() {
        String time = "10:-50";

        int seconds = Task1.minutesToSeconds(time);

        assertThat(seconds).isEqualTo(-1);
    }

    @Test
    @DisplayName("Test - \"null\", expected - \"-1\"")
    void parseTimeTest5() {
        String time = null;

        int seconds = Task1.minutesToSeconds(time);

        assertThat(seconds).isEqualTo(-1);
    }
}
