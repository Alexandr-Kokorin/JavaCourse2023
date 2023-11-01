package edu.project2.generators;

import edu.project2.gameObject.Cell;
import edu.project2.gameObject.Maze;
import edu.project2.gameObject.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PrimsGenerator implements Generator {

    private static final int MIN_SIZE = 5;

    @Override
    public Maze generate(int height, int width) {
        if (height < MIN_SIZE || width < MIN_SIZE) {
            return new Maze(0, 0);
        }

        Random random = new Random(System.currentTimeMillis());
        Maze maze = new Maze(height, width);
        addAllWall(maze);

        int x = random.nextInt(1, width / 2) * 2 - 1;
        int y = random.nextInt(1, height / 2) * 2 - 1;
        List<Cell> visitedCells = new ArrayList<>();
        maze.getGrid()[x][y].setType(Type.PASSAGE);
        visitedCells.add(maze.getGrid()[x][y]);

        while (!visitedCells.isEmpty()) {
            int indexCell = random.nextInt(visitedCells.size());
            List<Cell> neighbors = getUnvisitedNeighbors(maze, visitedCells.get(indexCell));
            if (neighbors.size() != 0) {
                int index = random.nextInt(neighbors.size());
                createPassage(maze, visitedCells.get(indexCell), neighbors.get(index));
                visitedCells.add(neighbors.get(index));
            }
            if (neighbors.size() == 1 || neighbors.size() == 0) {
                visitedCells.remove(indexCell);
            }
        }
        return maze;
    }

    private void addAllWall(Maze maze) {
        for (int i = 0; i < maze.getHeight(); i++) {
            for (int j = 0; j < maze.getWidth(); j++) {
                maze.addCell(i, j, Type.WALL);
            }
        }
    }

    private List<Cell> getUnvisitedNeighbors(Maze maze, Cell cell) {
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

    private boolean checkCoordinate(int row, int col, int height, int width) {
        return row >= 0 && row < height - 1 && col >= 0 && col < width - 1;
    }

    private void createPassage(Maze maze, Cell begin, Cell end) {
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
