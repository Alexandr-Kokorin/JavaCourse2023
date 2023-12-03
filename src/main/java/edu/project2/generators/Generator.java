package edu.project2.generators;

import edu.project2.gameObject.Cell;
import edu.project2.gameObject.Maze;
import edu.project2.gameObject.Type;
import java.util.ArrayList;
import java.util.List;

public interface Generator {

    int MIN_SIZE = 5;

    Maze generate(int height, int width);

    default void setAllWall(Maze maze) {
        for (int i = 0; i < maze.getHeight(); i++) {
            for (int j = 0; j < maze.getWidth(); j++) {
                maze.setCell(i, j, Type.WALL);
            }
        }
    }

    default List<Cell> getUnvisitedNeighbors(Maze maze, Cell cell) {
        List<Cell> neighbors = new ArrayList<>();
        int row = cell.getCoordinate().row();
        int col = cell.getCoordinate().col();
        if (checkCoordinate(row + 2, col, maze.getHeight(), maze.getWidth())
            && maze.getGrid()[row + 2][col].getType() == Type.WALL) {
            neighbors.add(maze.getGrid()[row + 2][col]);
        }
        if (checkCoordinate(row - 2, col, maze.getHeight(), maze.getWidth())
            && maze.getGrid()[row - 2][col].getType() == Type.WALL) {
            neighbors.add(maze.getGrid()[row - 2][col]);
        }
        if (checkCoordinate(row, col + 2, maze.getHeight(), maze.getWidth())
            && maze.getGrid()[row][col + 2].getType() == Type.WALL) {
            neighbors.add(maze.getGrid()[row][col + 2]);
        }
        if (checkCoordinate(row, col - 2, maze.getHeight(), maze.getWidth())
            && maze.getGrid()[row][col - 2].getType() == Type.WALL) {
            neighbors.add(maze.getGrid()[row][col - 2]);
        }
        return neighbors;
    }

    default boolean checkCoordinate(int row, int col, int height, int width) {
        return row >= 0 && row < height - 1 && col >= 0 && col < width - 1;
    }

    default void createPassage(Maze maze, Cell begin, Cell end) {
        int deltaRow = end.getCoordinate().row() - begin.getCoordinate().row();
        deltaRow = deltaRow != 0 ? deltaRow / Math.abs(deltaRow) : deltaRow;
        int deltaCol = end.getCoordinate().col() - begin.getCoordinate().col();
        deltaCol = deltaCol != 0 ? deltaCol / Math.abs(deltaCol) : deltaCol;
        begin.setType(Type.PASSAGE);
        end.setType(Type.PASSAGE);
        int row = begin.getCoordinate().row();
        int col = begin.getCoordinate().col();
        maze.getGrid()[row + deltaRow][col + deltaCol].setType(Type.PASSAGE);
    }
}
