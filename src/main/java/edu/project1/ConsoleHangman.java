package edu.project1;

import java.util.Scanner;
import org.jetbrains.annotations.NotNull;

public class ConsoleHangman {

    private final static Scanner SCANNER = new Scanner(System.in);
    private final HangmanSession session;

    public ConsoleHangman(String word, int maxAttempts) {
        session = new HangmanSession(word, maxAttempts);
    }

    public void run() {
        String input;
        do {
            write("Guess a letter:");
            input = read();
            if (isOneLetter(input)) {
                session.addGuess(input.charAt(0));
                write(session.getReplyMessage());
                write(session.getWordMassage());
            }
        } while (!isExit(input));

        if (session.getStatus() == Status.WIN) {
            write("You won!");
        } else if (session.getStatus() == Status.LOSS) {
            write("You lost!");
        }
    }

    boolean isExit(String string) {
        return string.equalsIgnoreCase("exit")
            || session.getStatus() == Status.LOSS
            || session.getStatus() == Status.WIN;
    }

    boolean isOneLetter(String string) {
        return string.length() == 1;
    }

    @NotNull
    private String read() {
        return SCANNER.nextLine();
    }

    @SuppressWarnings("RegexpSinglelineJava")
    private void write(String string) {
        System.out.println(string);
    }

    HangmanSession getHangmanSession() {
        return session;
    }
}
