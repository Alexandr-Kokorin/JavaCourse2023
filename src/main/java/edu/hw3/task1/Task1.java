package edu.hw3.task1;

import java.util.Objects;

public final class Task1 {

    private Task1() {}

    public static String atbash(String string) {
        if (Objects.isNull(string)) {
            return "";
        }
        StringBuilder result = new StringBuilder(string);
        for (int i = 0; i < result.length(); i++) {
            result.setCharAt(i, getEncryptedChar(result.charAt(i)));
        }
        return result.toString();
    }

    private static char getEncryptedChar(char c) {
        if (('a' <= c && c <= 'z')) {
            return (char) ('z' - (c - 'a'));
        } else if (('A' <= c && c <= 'Z')) {
            return (char) ('Z' - (c - 'A'));
        } else {
            return c;
        }
    }
}
