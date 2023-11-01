package edu.project2.solvers;

import edu.project2.gameObject.Cell;
import edu.project2.gameObject.Coordinate;
import edu.project2.gameObject.Maze;
import edu.project2.gameObject.Type;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.Stack;

public class DFSSolver implements Solver {

    @Override
    public List<Coordinate> solve(Maze maze, Coordinate start, Coordinate end) {
        if (maze.getHeight() == 0 || maze.getWidth() == 0
            || maze.getGrid()[start.row()][start.col()].getType() == Type.WALL
            || maze.getGrid()[end.row()][end.col()].getType() == Type.WALL) {
            return List.of();
        }

        Random random = new Random(System.currentTimeMillis());
        Set<Coordinate> visitedCells = new HashSet<>();
        Stack<Coordinate> path = new Stack<>();

        visitedCells.add(maze.getGrid()[start.row()][start.col()].getCoordinate());
        path.push(maze.getGrid()[start.row()][start.col()].getCoordinate());

        while (!path.peek().equals(end)) {
            List<Coordinate> neighbors = getUnvisitedNeighbors(maze, path.peek(), visitedCells);
            if (neighbors.size() > 0) {
                int index = random.nextInt(neighbors.size());
                visitedCells.add(neighbors.get(index));
                path.push(neighbors.get(index));
            } else {
                path.pop();
                if (path.isEmpty()) {
                    return List.of();
                }
            }
        }
        return List.copyOf(path);
    }

    private List<Coordinate> getUnvisitedNeighbors(Maze maze, Coordinate coordinate, Set<Coordinate> visitedCells) {
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

    private boolean checkCoordinate(int row, int col, int height, int width) {
        return row >= 0 && row < height && col >= 0 && col < width;
    }
}
