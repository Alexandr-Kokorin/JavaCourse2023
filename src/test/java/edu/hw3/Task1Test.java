package edu.hw3;

import edu.hw3.task1.Task1;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DisplayName("TestAtbash")
public class Task1Test {

    @Test
    @DisplayName("Test - \"Hello world!\", expected - \"Svool dliow!\"")
    void atbashTest1() {
        String string = "Hello world!";

        String result = Task1.atbash(string);

        assertThat(result).isEqualTo("Svool dliow!");
    }

    @Test
    @DisplayName("Test - \"long massage\", expected - \"correct long massage\"")
    void atbashTest2() {
        String string =
            "Any fool can write code that a computer can understand. Good programmers write code that humans can understand. ― Martin Fowler";

        String result = Task1.atbash(string);

        assertThat(result).isEqualTo(
            "Zmb ullo xzm dirgv xlwv gszg z xlnkfgvi xzm fmwvihgzmw. Tllw kiltiznnvih dirgv xlwv gszg sfnzmh xzm fmwvihgzmw. ― Nzigrm Uldovi");
    }

    @Test
    @DisplayName("Test - \"\", expected - \"\"")
    void atbashTest3() {
        String string = "";

        String result = Task1.atbash(string);

        assertThat(result).isEqualTo("");
    }

    @Test
    @DisplayName("Test - \"null\", expected - \"\"")
    void atbashTest4() {
        String string = null;

        String result = Task1.atbash(string);

        assertThat(result).isEqualTo("");
    }
}
