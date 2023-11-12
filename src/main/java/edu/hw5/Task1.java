package edu.hw5;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public final class Task1 {

    private Task1() {}

    public static Duration averageTime(String[] times) {
        if (Objects.isNull(times) || times.length == 0) {
            return null;
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd, HH:mm");
        Duration duration = Duration.ZERO;
        for (String time: times) {
            String[] startAndEnd = time.split(" - ");
            Instant start = LocalDateTime.parse(startAndEnd[0], formatter).toInstant(ZoneOffset.UTC);
            Instant end = LocalDateTime.parse(startAndEnd[1], formatter).toInstant(ZoneOffset.UTC);
            duration = duration.plus(Duration.between(start, end));
        }
        return duration.dividedBy(times.length);
    }
}
