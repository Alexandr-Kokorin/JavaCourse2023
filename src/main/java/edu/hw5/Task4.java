package edu.hw5;

import java.util.Objects;

public final class Task4 {

    private Task4() {}

    public static boolean isPasswordSecure(String password) {
        if (Objects.isNull(password)) {
            return false;
        }
        return password.matches(".*[~!@#$%^&*|].*");
    }
}
