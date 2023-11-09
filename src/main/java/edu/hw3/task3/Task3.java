package edu.hw3.task3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public final class Task3 {

    private Task3() {}

    public static <T> Map<T, Long> freqDict(List<T> list) {
        if (Objects.isNull(list)) {
            return new HashMap<>();
        }
        return list.stream().collect(Collectors.groupingBy(o -> o, Collectors.counting()));
    }
}
