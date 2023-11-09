package edu.hw3.task2;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class Task2 {

    private Task2() {}

    public static String[] clusterize(String string) {
        if (Objects.isNull(string)) {
            return new String[0];
        }
        List<String> result = new ArrayList<>();
        int countBracket = 0;
        int begin = 0;
        for (int i = 0; i < string.length(); i++) {
            countBracket += string.charAt(i) == '(' ? 1 : -1;
            if (countBracket == 0) {
                result.add(string.substring(begin, i + 1));
                begin = i + 1;
            }
            if (countBracket < 0) {
                break;
            }
        }
        return result.toArray(String[]::new);
    }
}
