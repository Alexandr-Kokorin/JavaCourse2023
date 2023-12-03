package edu.hw5;

import java.util.Objects;

public final class Task7 {

    private Task7() {}

    public static boolean regex1(String string) {
        if (Objects.isNull(string)) {
            return false;
        }
        return string.matches("[01]{2}0[01]*");
    }

    public static boolean regex2(String string) {
        if (Objects.isNull(string)) {
            return false;
        }
        return string.matches("(0[01]*0)|(1[01]*1)");
    }

    public static boolean regex3(String string) {
        if (Objects.isNull(string)) {
            return false;
        }
        return string.matches("[01]{1,3}");
    }
}
