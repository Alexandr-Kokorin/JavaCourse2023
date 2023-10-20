package edu.project1;

import java.util.List;
import java.util.Random;
import org.jetbrains.annotations.NotNull;

public final class Dictionary {

    private Dictionary() {}

    private static final List<String> WORDS = List.of("hello", "car", "house", "ball");

    @NotNull
    public static String getRandomWord() {
        Random random = new Random();
        return WORDS.get(random.nextInt(WORDS.size()));
    }
}
