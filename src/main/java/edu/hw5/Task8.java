package edu.hw5;

import java.util.Objects;

public final class Task8 {

    private Task8() {}

    public static boolean regex1(String string) {
        if (Objects.isNull(string)) {
            return false;
        }
        return string.matches("([01][01])*[01]");
    }

    public static boolean regex2(String string) {
        if (Objects.isNull(string)) {
            return false;
        }
        return string.matches("(0([01][01])*)|(1([01][01])*[01])");
    }

    public static boolean regex4(String string) {
        if (Objects.isNull(string)) {
            return false;
        }
        return string.matches("(?!.*11|.*111).*");
    }

    public static boolean regex5(String string) {
        if (Objects.isNull(string)) {
            return false;
        }
        return string.matches("(1[01])*|(1[01])*1");
    }

    public static boolean regex7(String string) {
        if (Objects.isNull(string)) {
            return false;
        }
        return string.matches("(0[01])*0|([01]0)*1|([01]0)*0|([01]0)*|(0[01])*");
    }
}
