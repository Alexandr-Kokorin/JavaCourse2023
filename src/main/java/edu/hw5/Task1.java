package edu.hw5;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public final class Task1 {

    private Task1() {}

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd, HH:mm");

    public static Duration averageTime(String[] times) {
        if (Objects.isNull(times) || times.length == 0) {
            return null;
        }
        Duration duration = Duration.ZERO;
        for (String time: times) {
            String[] startAndEnd = time.split(" - ");
            Instant start = LocalDateTime.parse(startAndEnd[0], FORMATTER).toInstant(ZoneOffset.UTC);
            Instant end = LocalDateTime.parse(startAndEnd[1], FORMATTER).toInstant(ZoneOffset.UTC);
            duration = duration.plus(Duration.between(start, end));
        }
        return duration.dividedBy(times.length);
    }
}
