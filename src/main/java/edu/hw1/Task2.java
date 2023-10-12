package edu.hw1;

public final class Task2 {

    private static final int NUMBER_SYSTEM = 10;

    private Task2() {}

    public static int countDigits(int number) {
        if (number == 0) {
            return 1;
        }
        int count = 0;
        int temp = number;
        while (temp != 0) {
            temp /= NUMBER_SYSTEM;
            count++;
        }
        return count;
    }
}
