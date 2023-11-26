package edu.hw7.task2;

import java.math.BigInteger;
import java.util.stream.IntStream;

public final class Task2 {

    private Task2() {}

    public static BigInteger factorial(int n) {
        if (n < 2) {
            return BigInteger.valueOf(1);
        }
        return IntStream.rangeClosed(2, n).parallel()
            .mapToObj(BigInteger::valueOf).reduce(BigInteger::multiply).orElseThrow();
    }
}
