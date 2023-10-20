package edu.project1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ConsoleHangmanTest {

    private final ConsoleHangman consoleHangman = new ConsoleHangman("home", 5);

    @Test
    @DisplayName("TestValidateInput - \"h\", expected - \"true\"")
    void validateTest1() {
        String string = "h";

        boolean result = consoleHangman.isOneLetter(string);

        assertThat(result).isEqualTo(true);
    }

    @Test
    @DisplayName("TestValidateInput - \"hof\", expected - \"false\"")
    void validateTest2() {
        String string = "hof";

        boolean result = consoleHangman.isOneLetter(string);

        assertThat(result).isEqualTo(false);
    }

    @Test
    @DisplayName("TestExit - \"exit\", expected - \"true\"")
    void exitTest1() {
        String string = "exit";

        boolean result = consoleHangman.isExit(string);

        assertThat(result).isEqualTo(true);
    }

    @Test
    @DisplayName("TestExit - \"abc\", expected - \"false\"")
    void exitTest2() {
        String string = "abc";

        boolean result = consoleHangman.isExit(string);

        assertThat(result).isEqualTo(false);
    }
}
