package edu.hw1;

import java.util.Objects;

public final class Task8 {

    private static final int SIZE = 8;

    private Task8() {}

    public static boolean knightBoardCapture(int[][] matrix) {
        if (Objects.isNull(matrix) || Objects.isNull(matrix[0])) {
            return false;
        }
        boolean result = true;
        for (int x = 0; x < SIZE; x++) {
            for (int y = 0; y < SIZE; y++) {
                if (isHorseEat(matrix, x, y)) {
                    result = false;
                }
            }
        }
        return result;
    }

    private static boolean isHorseEat(int[][] matrix, int x, int y) {
        return matrix[x][y] == 1 && (isHorseEatOnTop(matrix, x, y) || isHorseEatBelow(matrix, x, y)
                                    || isHorseEatOnLeft(matrix, x, y) || isHorseEatOnRight(matrix, x, y));
    }

    private static boolean isHorseEatOnTop(int[][] matrix, int x, int y) {
        return  ((isCorrectCoordinates(x - 1, y - 2) && matrix[x - 1][y - 2] == 1)
                || (isCorrectCoordinates(x + 1, y - 2) && matrix[x + 1][y - 2] == 1));
    }

    private static boolean isHorseEatOnRight(int[][] matrix, int x, int y) {
        return  ((isCorrectCoordinates(x + 2, y + 1) && matrix[x + 2][y + 1] == 1)
            || (isCorrectCoordinates(x + 2, y - 1) && matrix[x + 2][y - 1] == 1));
    }

    private static boolean isHorseEatOnLeft(int[][] matrix, int x, int y) {
        return  ((isCorrectCoordinates(x - 2, y + 1) && matrix[x - 2][y + 1] == 1)
            || (isCorrectCoordinates(x - 2, y - 1) && matrix[x - 2][y - 1] == 1));
    }

    private static boolean isHorseEatBelow(int[][] matrix, int x, int y) {
        return  ((isCorrectCoordinates(x - 1, y + 2) && matrix[x - 1][y + 2] == 1)
            || (isCorrectCoordinates(x + 1, y + 2) && matrix[x + 1][y + 2] == 1));
    }

    private static boolean isCorrectCoordinates(int x, int y) {
        return x >= 0 && x < SIZE && y >= 0 && y < SIZE;
    }
}
