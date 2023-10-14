package edu.hw1;

public final class Task7 {

    private Task7() {}

    public static int rotateLeft(int n, int shift) {
        if (n <= 0 || shift < 0) {
            return -1;
        }
        String string = Integer.toBinaryString(n);
        char[] digits = new char[string.length()];
        for (int i = 0; i < string.length(); i++) {
            int index = (i - shift) % string.length();
            index = index < 0 ? string.length() + index : index;
            digits[index] = string.charAt(i);
        }
        return Integer.parseInt(new String(digits), 2);
    }

    public static int rotateRight(int n, int shift) {
        if (n <= 0 || shift < 0) {
            return -1;
        }
        String string = Integer.toBinaryString(n);
        char[] digits = new char[string.length()];
        for (int i = 0; i < string.length(); i++) {
            int index = (i + shift) % string.length();
            digits[index] = string.charAt(i);
        }
        return Integer.parseInt(new String(digits), 2);
    }
}
