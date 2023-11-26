package edu.hw5;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class Task2 {

    private static final int MONTHS_PER_YEAR = 12;
    private static final int DAY_OF_MONTH = 13;

    private Task2() {}

    public static List<LocalDate> allFridays13(int year) {
        List<LocalDate> result = new ArrayList<>();
        LocalDate date = LocalDate.of(year, 1, DAY_OF_MONTH);
        for (int i = 0; i < MONTHS_PER_YEAR; i++) {
            if (date.getDayOfWeek() == DayOfWeek.FRIDAY) {
                result.add(LocalDate.from(date));
            }
            date = date.plusMonths(1);
        }
        return result;
    }

    public static LocalDate nextFriday13(LocalDate date) {
        if (Objects.isNull(date)) {
            return null;
        }
        LocalDate friday13 = LocalDate.from(date);
        do {
            friday13 = friday13.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
        } while (friday13.getDayOfMonth() != DAY_OF_MONTH);
        return friday13;
    }
}
