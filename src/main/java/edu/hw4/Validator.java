package edu.hw4;

import java.util.HashSet;
import java.util.Set;

public final class Validator {

    private static final int MAX_AGE = 100;
    private static final int MAX_HEIGHT = 1000;
    private static final int MAX_WEIGHT = 1000;

    private Validator() {}

    public static Set<ValidationError> validate(Animal animal) {
        Set<ValidationError> set = new HashSet<>();
        if (animal.age() < 0 || animal.age() > MAX_AGE) {
            set.add(new ValidationError("age"));
        }
        if (animal.height() < 0 || animal.height() > MAX_HEIGHT) {
            set.add(new ValidationError("height"));
        }
        if (animal.weight() < 0 || animal.weight() > MAX_WEIGHT) {
            set.add(new ValidationError("weight"));
        }
        return set;
    }

    public static String toString(Set<ValidationError> set) {
        StringBuilder result = new StringBuilder();
        set.forEach(validationError -> result.append(validationError.name()).append(' '));
        return result.deleteCharAt(result.length() - 1).toString();
    }
}
