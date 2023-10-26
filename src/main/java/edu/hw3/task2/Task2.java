package edu.hw3.task2;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

public final class Task2 {

    private final static Stack<Character> BRACKET = new Stack<>();

    private Task2() {}

    public static String[] clusterize(String string) {
        if (Objects.isNull(string)) {
            return new String[0];
        }
        List<String> result = new ArrayList<>();

        int begin = 0;
        for (int i = 0; i < string.length(); i++) {
            switch (getState(string.charAt(i))) {
                case PUSH -> BRACKET.push('(');
                case POP -> BRACKET.pop();
                default -> {
                    return result.toArray(String[]::new);
                }
            }
            if (BRACKET.isEmpty()) {
                result.add(string.substring(begin, i + 1));
                begin = i + 1;
            }
        }
        return result.toArray(String[]::new);
    }

    private static State getState(char c) {
        if (c == '(') {
            return State.PUSH;
        } else if (c == ')' && !BRACKET.isEmpty() && BRACKET.peek() == '(') {
            return State.POP;
        } else {
            return State.BREAK;
        }
    }
}
