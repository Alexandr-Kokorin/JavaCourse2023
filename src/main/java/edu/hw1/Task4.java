package edu.hw1;

import java.util.Objects;

public final class Task4 {

    private Task4() {}

    public static String fixString(String string) {
        if (Objects.isNull(string)) {
            return "";
        }
        StringBuilder result = new StringBuilder(string);
        for (int i = 1; i < string.length(); i += 2) {
            result.setCharAt(i - 1, string.charAt(i));
            result.setCharAt(i, string.charAt(i - 1));
        }
        return result.toString();
    }
}
