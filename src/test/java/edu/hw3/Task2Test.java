package edu.hw3;

import edu.hw3.task2.Task2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DisplayName("TestClusterize")
public class Task2Test {

    @Test
    @DisplayName("Test - \"()()()\", expected - \"[\"()\", \"()\", \"()\"]\"")
    void clusterizeTest1() {
        String string = "()()()";

        String[] result = Task2.clusterize(string);

        assertThat(result).containsExactly("()", "()", "()");
    }

    @Test
    @DisplayName("Test - \"((()))\", expected - \"[\"((()))\"]\"")
    void clusterizeTest2() {
        String string = "((()))";

        String[] result = Task2.clusterize(string);

        assertThat(result).containsExactly("((()))");
    }

    @Test
    @DisplayName("Test - \"((()))(())()()(()())\", expected - \"[\"((()))\", \"(())\", \"()\", \"()\", \"(()())\"]\"")
    void clusterizeTest3() {
        String string = "((()))(())()()(()())";

        String[] result = Task2.clusterize(string);

        assertThat(result).containsExactly("((()))", "(())", "()", "()", "(()())");
    }

    @Test
    @DisplayName("Test - \"((())())(()(()()))\", expected - \"[\"((())())\", \"(()(()()))\"]\"")
    void clusterizeTest4() {
        String string = "((())())(()(()()))";

        String[] result = Task2.clusterize(string);

        assertThat(result).containsExactly("((())())", "(()(()()))");
    }

    @Test
    @DisplayName("Test - \"())\", expected - \"[\"()\"]\"")
    void clusterizeTest5() {
        String string = "())";

        String[] result = Task2.clusterize(string);

        assertThat(result).containsExactly("()");
    }

    @Test
    @DisplayName("Test - \"null\", expected - \"[]\"")
    void clusterizeTest6() {
        String string = null;

        String[] result = Task2.clusterize(string);

        assertThat(result).containsExactly();
    }
}
