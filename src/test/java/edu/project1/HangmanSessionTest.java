package edu.project1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class HangmanSessionTest {

    @Test
    @DisplayName("TestStatus - \"h\", expected - \"HIT\"")
    void statusTest1() {
        ConsoleHangman consoleHangman = new ConsoleHangman("home", 5);
        HangmanSession hangmanSession = consoleHangman.getHangmanSession();
        char c = 'h';

        hangmanSession.addGuess(c);
        Status result = hangmanSession.getStatus();

        assertThat(result).isEqualTo(Status.HIT);
    }

    @Test
    @DisplayName("TestStatus - \"#\", expected - \"MISTAKE\"")
    void statusTest2() {
        ConsoleHangman consoleHangman = new ConsoleHangman("home", 5);
        HangmanSession hangmanSession = consoleHangman.getHangmanSession();
        char c = '#';

        hangmanSession.addGuess(c);
        Status result = hangmanSession.getStatus();

        assertThat(result).isEqualTo(Status.MISTAKE);
    }

    @Test
    @DisplayName("TestStatus - \"h, o, m, e\", expected - \"WIN\"")
    void statusTest3() {
        ConsoleHangman consoleHangman = new ConsoleHangman("home", 5);
        HangmanSession hangmanSession = consoleHangman.getHangmanSession();
        char c1 = 'h';
        char c2 = 'o';
        char c3 = 'm';
        char c4 = 'e';

        hangmanSession.addGuess(c1);
        hangmanSession.addGuess(c2);
        hangmanSession.addGuess(c3);
        hangmanSession.addGuess(c4);
        Status result = hangmanSession.getStatus();

        assertThat(result).isEqualTo(Status.WIN);
    }

    @Test
    @DisplayName("TestStatus - \"#, #, #, #, #\", expected - \"LOSS\"")
    void statusTest4() {
        ConsoleHangman consoleHangman = new ConsoleHangman("home", 5);
        HangmanSession hangmanSession = consoleHangman.getHangmanSession();
        char c = '#';

        hangmanSession.addGuess(c);
        hangmanSession.addGuess(c);
        hangmanSession.addGuess(c);
        hangmanSession.addGuess(c);
        hangmanSession.addGuess(c);
        Status result = hangmanSession.getStatus();

        assertThat(result).isEqualTo(Status.LOSS);
    }


}
