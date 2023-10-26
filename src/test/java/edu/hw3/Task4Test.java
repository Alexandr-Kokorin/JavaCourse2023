package edu.hw3;

import edu.hw3.task4.Task4;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DisplayName("TestConvertToRoman")
public class Task4Test {

    @Test
    @DisplayName("Test - \"2\", expected - \"II\"")
    void convertToRomanTest1() {
        int number = 2;

        String result = Task4.convertToRoman(number);

        assertThat(result).isEqualTo("II");
    }

    @Test
    @DisplayName("Test - \"12\", expected - \"XII\"")
    void convertToRomanTest2() {
        int number = 12;

        String result = Task4.convertToRoman(number);

        assertThat(result).isEqualTo("XII");
    }

    @Test
    @DisplayName("Test - \"16\", expected - \"XVI\"")
    void convertToRomanTest3() {
        int number = 16;

        String result = Task4.convertToRoman(number);

        assertThat(result).isEqualTo("XVI");
    }

    @Test
    @DisplayName("Test - \"2017\", expected - \"MMXVII\"")
    void convertToRomanTest4() {
        int number = 2017;

        String result = Task4.convertToRoman(number);

        assertThat(result).isEqualTo("MMXVII");
    }

    @Test
    @DisplayName("Test - \"-2\", expected - \"\"")
    void convertToRomanTest5() {
        int number = -2;

        String result = Task4.convertToRoman(number);

        assertThat(result).isEqualTo("");
    }
}
