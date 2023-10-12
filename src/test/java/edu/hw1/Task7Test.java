package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DisplayName("TestRotateRightAndLeft")
public class Task7Test {

    @Test
    @DisplayName("Right test - \"8, 1\", expected - \"4\"")
    void RotateRightTest1() {
        int number = 8;
        int shift = 1;

        int result = Task7.rotateRight(number, shift);

        assertThat(result).isEqualTo(4);
    }

    @Test
    @DisplayName("Right test - \"8, -1\", expected - \"-1\"")
    void RotateRightTest2() {
        int number = 8;
        int shift = -1;

        int result = Task7.rotateRight(number, shift);

        assertThat(result).isEqualTo(-1);
    }

    @Test
    @DisplayName("Left test - \"16, 1\", expected - \"1\"")
    void RotateLeftTest1() {
        int number = 16;
        int shift = 1;

        int result = Task7.rotateLeft(number, shift);

        assertThat(result).isEqualTo(1);
    }

    @Test
    @DisplayName("Left test - \"17, 2\", expected - \"6\"")
    void RotateLeftTest2() {
        int number = 17;
        int shift = 2;

        int result = Task7.rotateLeft(number, shift);

        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("Left test - \"-16, 1\", expected - \"-1\"")
    void RotateLeftTest3() {
        int number = -16;
        int shift = 1;

        int result = Task7.rotateLeft(number, shift);

        assertThat(result).isEqualTo(-1);
    }
}
