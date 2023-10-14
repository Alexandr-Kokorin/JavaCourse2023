package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DisplayName("TestIsNestable")
public class Task3Test {

    @Test
    @DisplayName("Test - \"[1, 2, 3, 4], [0, 6]\", expected - \"true\"")
    void isNestableTest1() {
        int[] array1 = new int[]{1, 2, 3, 4};
        int[] array2 = new int[]{0, 6};

        boolean result = Task3.isNestable(array1, array2);

        assertThat(result).isEqualTo(true);
    }

    @Test
    @DisplayName("Test - \"[3, 1], [4, 0]\", expected - \"true\"")
    void isNestableTest2() {
        int[] array1 = new int[]{3, 1};
        int[] array2 = new int[]{4, 0};

        boolean result = Task3.isNestable(array1, array2);

        assertThat(result).isEqualTo(true);
    }

    @Test
    @DisplayName("Test - \"[9, 9, 8], [8, 9]\", expected - \"false\"")
    void isNestableTest3() {
        int[] array1 = new int[]{9, 9, 8};
        int[] array2 = new int[]{8, 9};

        boolean result = Task3.isNestable(array1, array2);

        assertThat(result).isEqualTo(false);
    }

    @Test
    @DisplayName("Test - \"[1, 2, 3, 4], [2, 3]\", expected - \"false\"")
    void isNestableTest4() {
        int[] array1 = new int[]{1, 2, 3, 4};
        int[] array2 = new int[]{2, 3};

        boolean result = Task3.isNestable(array1, array2);

        assertThat(result).isEqualTo(false);
    }

    @Test
    @DisplayName("Test - \"[], []\", expected - \"false\"")
    void isNestableTest5() {
        int[] array1 = new int[]{};
        int[] array2 = new int[]{};

        boolean result = Task3.isNestable(array1, array2);

        assertThat(result).isEqualTo(false);
    }

    @Test
    @DisplayName("Test - \"null, null\", expected - \"false\"")
    void isNestableTest6() {
        int[] array1 = null;
        int[] array2 = null;

        boolean result = Task3.isNestable(array1, array2);

        assertThat(result).isEqualTo(false);
    }
}
