package edu.hw1;

import java.util.Objects;

public final class Task3 {

    private Task3() {}

    public static boolean isNestable(int[] array1, int[] array2) {
        if (Objects.isNull(array1) || Objects.isNull(array2) || array1.length == 0 || array2.length == 0) {
            return false;
        }
        return min(array1) > min(array2) && max(array1) < max(array2);
    }

    private static int max(int[] array) {
        int max = array[0];
        for (int number : array) {
            max = Math.max(max, number);
        }
        return max;
    }

    private static int min(int[] array) {
        int min = array[0];
        for (int number : array) {
            min = Math.min(min, number);
        }
        return min;
    }
}
