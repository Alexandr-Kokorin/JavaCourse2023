package edu.hw3.task4;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("MagicNumber")
public final class Task4 {

    private static final Map<Integer, String> DICTIONARY;

    static {
        DICTIONARY = new HashMap<>();
        DICTIONARY.put(1, "I");
        DICTIONARY.put(4, "IV");
        DICTIONARY.put(5, "V");
        DICTIONARY.put(9, "IX");
        DICTIONARY.put(10, "X");
        DICTIONARY.put(40, "XL");
        DICTIONARY.put(50, "L");
        DICTIONARY.put(90, "XC");
        DICTIONARY.put(100, "C");
        DICTIONARY.put(400, "CD");
        DICTIONARY.put(500, "D");
        DICTIONARY.put(900, "CM");
        DICTIONARY.put(1000, "M");
    }

    private Task4() {}

    public static String convertToRoman(int number) {
        if (number < 1 || number > 3999) {
            return "";
        }
        StringBuilder result = new StringBuilder();
        int num = number;
        int minus = 1000;
        while (num > 0) {
            while (minus > num) {
                minus = getSmallerNumber(minus);
            }
            num -= minus;
            result.append(DICTIONARY.get(minus));
        }
        return result.toString();
    }

    private static int getSmallerNumber(int n) {
        String num = String.valueOf(n);
        int temp = switch (num.charAt(0)) {
            case '1', '5' -> 1;
            case '9' -> 4;
            case '4' -> 3;
            default -> 0;
        };
        return n - temp * (int) Math.pow(10, num.charAt(0) == '1' ? num.length() - 2 : num.length() - 1);
    }
}
