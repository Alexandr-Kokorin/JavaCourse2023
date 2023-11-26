package edu.hw5;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.Optional;

public final class Task3 {

    private Task3() {
    }

    public static Optional<LocalDate> parseDate(String string) {
        if (Objects.isNull(string)) {
            return Optional.empty();
        }
        return checkType1(string);
    }

    private static Optional<LocalDate> checkType1(String string) {
        if (string.matches("\\d{4}-\\d{2}-\\d{2}")) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            return Optional.of(LocalDate.parse(string, formatter));
        }
        return checkType2(string);
    }

    private static Optional<LocalDate> checkType2(String string) {
        if (string.matches("\\d{4}-\\d{1,2}-\\d{1,2}")) {
            String[] date = string.split("-");
            return Optional.of(LocalDate.of(Integer.parseInt(date[0]),
                Integer.parseInt(date[1]), Integer.parseInt(date[2])));
        }
        return checkType3(string);
    }

    private static Optional<LocalDate> checkType3(String string) {
        if (string.matches("\\d{1,2}/\\d{1,2}/\\d{4}")) {
            String[] date = string.split("/");
            return Optional.of(LocalDate.of(Integer.parseInt(date[2]),
                Integer.parseInt(date[1]), Integer.parseInt(date[0])));
        }
        return checkType4(string);
    }

    @SuppressWarnings("MagicNumber")
    private static Optional<LocalDate> checkType4(String string) {
        if (string.matches("\\d{1,2}/\\d{1,2}/\\d{2}")) {
            String[] date = string.split("/");
            return Optional.of(LocalDate.of(Integer.parseInt(date[2]), Integer.parseInt(date[1]),
                Integer.parseInt(date[0])).plusYears(2000));
        }
        return checkType5(string);
    }

    private static Optional<LocalDate> checkType5(String string) {
        return switch (string) {
            case "tomorrow" -> Optional.of(LocalDate.now().plusDays(1));
            case "today" -> Optional.of(LocalDate.now());
            case "yesterday" -> Optional.of(LocalDate.now().minusDays(1));
            default -> checkType6(string);
        };
    }

    private static Optional<LocalDate> checkType6(String string) {
        if (string.matches("\\d+ (day|days) ago")) {
            return Optional.of(LocalDate.now().minusDays(Integer.parseInt(string.split(" ")[0])));
        }
        return Optional.empty();
    }
}
