package edu.hw1;

import java.util.Objects;

public final class Task1 {

    private static final int LOWER_LIMIT = 0;
    private static final int UPPER_LIMIT = 60;
    private static final int SECONDS_PER_MINUTE = 60;

    private Task1() {}

    public static int minutesToSeconds(String time) {
        if (Objects.isNull(time)) {
            return -1;
        }
        String[] minutesAndSeconds = time.split(":");
        int minutes = Integer.parseInt(minutesAndSeconds[0]);
        int seconds = Integer.parseInt(minutesAndSeconds[1]);
        if (minutes < LOWER_LIMIT || seconds < LOWER_LIMIT || seconds >= UPPER_LIMIT) {
            return -1;
        }
        return minutes * SECONDS_PER_MINUTE + seconds;
    }
}
