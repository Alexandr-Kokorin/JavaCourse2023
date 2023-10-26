package edu.hw3.task3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public final class Task3 {

    private Task3() {}

    public static <T> Map<T, Integer> freqDict(List<T> list) {
        Map<T, Integer> dict = new HashMap<>();
        if (Objects.isNull(list)) {
            return dict;
        }
        for (T element: list) {
            if (dict.containsKey(element)) {
                dict.put(element, dict.get(element) + 1);
            } else {
                dict.put(element, 1);
            }
        }
        return dict;
    }
}
