package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DisplayName("TestCountDigits")
public class Task2Test {

    @Test
    @DisplayName("Test - \"4666\", expected - \"4\"")
    void countDigitsTest1() {
        int number = 4666;

        int count = Task2.countDigits(number);

        assertThat(count).isEqualTo(4);
    }

    @Test
    @DisplayName("Test - \"544\", expected - \"3\"")
    void countDigitsTest2() {
        int number = 544;

        int count = Task2.countDigits(number);

        assertThat(count).isEqualTo(3);
    }

    @Test
    @DisplayName("Test - \"0\", expected - \"1\"")
    void countDigitsTest3() {
        int number = 0;

        int count = Task2.countDigits(number);

        assertThat(count).isEqualTo(1);
    }

    @Test
    @DisplayName("Test - \"-500\", expected - \"3\"")
    void countDigitsTest4() {
        int number = -500;

        int count = Task2.countDigits(number);

        assertThat(count).isEqualTo(3);
    }
}
