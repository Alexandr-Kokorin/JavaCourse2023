package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DisplayName("TestIsPalindromeDescendant")
public class Task5Test {

    @Test
    @DisplayName("Test - \"11211230\", expected - \"true\"")
    void isPalindromeDescendantTest1() {
        int number = 11211230;

        boolean result = Task5.isPalindromeDescendant(number);

        assertThat(result).isEqualTo(true);
    }

    @Test
    @DisplayName("Test - \"23336014\", expected - \"true\"")
    void isPalindromeDescendantTest2() {
        int number = 23336014;

        boolean result = Task5.isPalindromeDescendant(number);

        assertThat(result).isEqualTo(true);
    }

    @Test
    @DisplayName("Test - \"11\", expected - \"true\"")
    void isPalindromeDescendantTest3() {
        int number = 11;

        boolean result = Task5.isPalindromeDescendant(number);

        assertThat(result).isEqualTo(true);
    }

    @Test
    @DisplayName("Test - \"123456\", expected - \"false\"")
    void isPalindromeDescendantTest4() {
        int number = 123456;

        boolean result = Task5.isPalindromeDescendant(number);

        assertThat(result).isEqualTo(false);
    }

    @Test
    @DisplayName("Test - \"-11\", expected - \"true\"")
    void isPalindromeDescendantTest5() {
        int number = -11;

        boolean result = Task5.isPalindromeDescendant(number);

        assertThat(result).isEqualTo(true);
    }
}
