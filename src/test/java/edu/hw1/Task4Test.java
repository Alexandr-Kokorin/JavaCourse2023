package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DisplayName("TestFixString")
public class Task4Test {

    @Test
    @DisplayName("Test - \"123456\", expected - \"214365\"")
    void fixStringTest1() {
        String string = "123456";

        String result = Task4.fixString(string);

        assertThat(result).isEqualTo("214365");
    }

    @Test
    @DisplayName("Test - \"hTsii  s aimex dpus rtni.g\", expected - \"This is a mixed up string.\"")
    void fixStringTest2() {
        String string = "hTsii  s aimex dpus rtni.g";

        String result = Task4.fixString(string);

        assertThat(result).isEqualTo("This is a mixed up string.");
    }

    @Test
    @DisplayName("Test - \"badce\", expected - \"abcde\"")
    void fixStringTest3() {
        String string = "badce";

        String result = Task4.fixString(string);

        assertThat(result).isEqualTo("abcde");
    }

    @Test
    @DisplayName("Test - \"\", expected - \"\"")
    void fixStringTest4() {
        String string = "";

        String result = Task4.fixString(string);

        assertThat(result).isEqualTo("");
    }

    @Test
    @DisplayName("Test - \"null\", expected - \"\"")
    void fixStringTest5() {
        String string = null;

        String result = Task4.fixString(string);

        assertThat(result).isEqualTo("");
    }
}
