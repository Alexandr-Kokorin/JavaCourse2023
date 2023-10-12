package edu.hw1;

public final class Task5 {

    private Task5() {}

    public static boolean isPalindromeDescendant(int number) {
        String string = String.valueOf(Math.abs(number));
        if (string.length() % 2 != 0) {
            return false;
        }
        String revers = new StringBuilder(string).reverse().toString();
        if (string.equals(revers)) {
            return true;
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < string.length(); i += 2) {
            result.append((string.charAt(i) - '0') + (string.charAt(i + 1) - '0'));
        }
        return isPalindromeDescendant(Integer.parseInt(result.toString()));
    }
}
