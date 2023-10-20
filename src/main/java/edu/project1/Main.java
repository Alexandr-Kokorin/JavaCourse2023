package edu.project1;

public final class Main {

    private static final int MAX_ATTEMPTS = 5;

    private Main() {}

    public static void main(String[] args) {
        ConsoleHangman consoleHangman = new ConsoleHangman(Dictionary.getRandomWord(), MAX_ATTEMPTS);
        consoleHangman.run();
    }
}
