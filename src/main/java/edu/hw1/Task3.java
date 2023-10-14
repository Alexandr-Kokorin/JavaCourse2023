package edu.hw1;

import java.util.Arrays;
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
        var result = Arrays.stream(array).max();
        return result.isPresent() ? result.getAsInt() : Integer.MIN_VALUE;
    }

    private static int min(int[] array) {
        var result = Arrays.stream(array).min();
        return result.isPresent() ? result.getAsInt() : Integer.MAX_VALUE;
    }
}
