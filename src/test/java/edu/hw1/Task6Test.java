package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DisplayName("TestCountK")
public class Task6Test {

    @Test
    @DisplayName("Test - \"6621\", expected - \"5\"")
    void countKTest1() {
        int number = 6621;

        int result = Task6.countK(number);

        assertThat(result).isEqualTo(5);
    }

    @Test
    @DisplayName("Test - \"1234\", expected - \"3\"")
    void countKTest2() {
        int number = 1234;

        int result = Task6.countK(number);

        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("Test - \"6174\", expected - \"0\"")
    void countKTest3() {
        int number = 6174;

        int result = Task6.countK(number);

        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("Test - \"6666\", expected - \"-1\"")
    void countKTest4() {
        int number = 6666;

        int result = Task6.countK(number);

        assertThat(result).isEqualTo(-1);
    }

    @Test
    @DisplayName("Test - \"225\", expected - \"-1\"")
    void countKTest5() {
        int number = 225;

        int result = Task6.countK(number);

        assertThat(result).isEqualTo(-1);
    }
}
