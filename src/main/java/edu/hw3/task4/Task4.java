package edu.hw3.task4;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("MagicNumber")
public final class Task4 {

    private static final Map<Integer, String> DICTIONARY;
    private static final List<Integer> NUMBERS;

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

        NUMBERS = List.of(1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1);
    }

    private Task4() {}

    public static String convertToRoman(int number) {
        if (number < 1 || number > 3999) {
            return "";
        }
        StringBuilder result = new StringBuilder();
        int n = number;
        int index = 0;
        while (n > 0) {
            while (NUMBERS.get(index) > n) {
                index++;
            }
            n -= NUMBERS.get(index);
            result.append(DICTIONARY.get(NUMBERS.get(index)));
        }
        return result.toString();
    }
}
