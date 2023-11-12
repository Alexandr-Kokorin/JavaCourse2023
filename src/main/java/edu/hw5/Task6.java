package edu.hw5;

import java.util.Objects;

public final class Task6 {

    private Task6() {}

    public static boolean isSubsequences(String subsequences, String text) {
        if (Objects.isNull(subsequences) || Objects.isNull(text)) {
            return false;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (char c: subsequences.toCharArray()) {
            stringBuilder.append("[^").append(c).append("]*+").append(c);
        }
        String regex = stringBuilder.append(".*").toString();
        return text.matches(regex);
    }
}
