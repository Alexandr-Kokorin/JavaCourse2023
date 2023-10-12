package edu.project1;

import java.util.HashSet;
import java.util.Set;
import org.jetbrains.annotations.NotNull;

public class HangmanSession {

    private final String word;
    private final Set<Character> userAnswer;
    private final int maxAttempts;
    private int attempts;
    private Status status;

    public HangmanSession(String word, int maxAttempts) {
        this.word = word;
        this.maxAttempts = maxAttempts;
        userAnswer = new HashSet<>();
        attempts = 0;
        status = Status.START;
    }

    public void addGuess(char letter) {
        if (word.indexOf(letter) != -1) {
            userAnswer.add(letter);
            status = isWin() ? Status.WIN : Status.HIT;
        } else {
            attempts++;
            status = isLoss() ? Status.LOSS : Status.MISTAKE;
        }
    }

    private boolean isWin() {
        boolean isWin = true;
        for (char c : word.toCharArray()) {
            if (!userAnswer.contains(c)) {
                isWin = false;
                break;
            }
        }
        return isWin;
    }

    private boolean isLoss() {
        return attempts >= maxAttempts;
    }

    @NotNull
    public String getReplyMessage() {
        if (status == Status.MISTAKE || status == Status.LOSS) {
            return "Missed, mistake " + attempts + " out of " + maxAttempts + ".";
        } else {
            return "Hit!";
        }
    }

    @NotNull
    public String getWordMassage() {
        StringBuilder result = new StringBuilder("\nThe word: ");
        for (char c : word.toCharArray()) {
            result.append(userAnswer.contains(c) ? c : '*');
        }
        return result.append("\n").toString();
    }

    public Status getStatus() {
        return status;
    }
}
