package edu.hw1;

import java.util.Arrays;
import java.util.Set;

public final class Task6 {

    private static final int LOWER_LIMIT = 1000;
    private static final int UPPER_LIMIT = 10000;
    private static final int KAPREKAR_NUMBER = 6174;
    private static final Set<Integer> FORBIDDEN_NUMBERS = Set.of(1111, 2222, 3333, 4444, 5555, 6666, 7777, 8888, 9999);

    private Task6() {}

    public static int countK(int number) {
        if (number <= LOWER_LIMIT || number >= UPPER_LIMIT || FORBIDDEN_NUMBERS.contains(number)) {
            return -1;
        }
        if (number == KAPREKAR_NUMBER) {
            return 0;
        }
        return countK(kaprekar(number)) + 1;
    }

    private static int kaprekar(int number) {
        char[] chars = String.valueOf(number).toCharArray();
        Arrays.sort(chars);
        int num1 = Integer.parseInt(new String(chars));
        int num2 = Integer.parseInt(new StringBuilder(new String(chars)).reverse().toString());
        return num2 - num1;
    }
}
