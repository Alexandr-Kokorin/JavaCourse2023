package edu.hw5;

import java.util.Objects;

public final class Task5 {

    private Task5() {}

    public static boolean isCorrectLicensePlate(String licensePlate) {
        if (Objects.isNull(licensePlate)) {
            return false;
        }
        return licensePlate.matches("^[АВЕКМНОРСТУХ]\\d{3}[АВЕКМНОРСТУХ]{2}\\d{2,3}$");
    }
}
