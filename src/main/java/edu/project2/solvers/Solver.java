package edu.project2.solvers;

import edu.project2.gameObject.Cell;
import edu.project2.gameObject.Coordinate;
import edu.project2.gameObject.Maze;
import edu.project2.gameObject.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public interface Solver {

    List<Coordinate> solve(Maze maze, Coordinate start, Coordinate end);

    default List<Coordinate> getUnvisitedNeighbors(Maze maze, Coordinate coordinate, Set<Coordinate> visitedCells) {
        List<Coordinate> neighbors = new ArrayList<>();
        int row = coordinate.row();
        int col = coordinate.col();
        Cell newCell = maze.getGrid()[row + 1][col];
        if (checkCoordinate(row + 1, col, maze.getHeight(), maze.getWidth())
            && newCell.getType() == Type.PASSAGE && !visitedCells.contains(newCell.getCoordinate())) {
            neighbors.add(newCell.getCoordinate());
        }
        newCell = maze.getGrid()[row - 1][col];
        if (checkCoordinate(row - 1, col, maze.getHeight(), maze.getWidth())
            && newCell.getType() == Type.PASSAGE && !visitedCells.contains(newCell.getCoordinate())) {
            neighbors.add(newCell.getCoordinate());
        }
        newCell = maze.getGrid()[row][col + 1];
        if (checkCoordinate(row, col + 1, maze.getHeight(), maze.getWidth())
            && newCell.getType() == Type.PASSAGE && !visitedCells.contains(newCell.getCoordinate())) {
            neighbors.add(newCell.getCoordinate());
        }
        newCell = maze.getGrid()[row][col - 1];
        if (checkCoordinate(row, col - 1, maze.getHeight(), maze.getWidth())
            && newCell.getType() == Type.PASSAGE && !visitedCells.contains(newCell.getCoordinate())) {
            neighbors.add(newCell.getCoordinate());
        }
        return neighbors;
    }

    default boolean checkCoordinate(int row, int col, int height, int width) {
        return row >= 0 && row < height && col >= 0 && col < width;
    }
}
