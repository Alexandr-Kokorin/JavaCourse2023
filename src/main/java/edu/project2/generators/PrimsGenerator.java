package edu.project2.generators;

import edu.project2.gameObject.Cell;
import edu.project2.gameObject.Maze;
import edu.project2.gameObject.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PrimsGenerator implements Generator {

    @Override
    public Maze generate(int height, int width) {
        if (height < MIN_SIZE || width < MIN_SIZE) {
            return new Maze(0, 0);
        }

        Random random = new Random(System.currentTimeMillis());
        Maze maze = new Maze(height, width);
        setAllWall(maze);

        int x = random.nextInt(1, width / 2) * 2 - 1;
        int y = random.nextInt(1, height / 2) * 2 - 1;
        List<Cell> visitedCells = new ArrayList<>();
        maze.getGrid()[x][y].setType(Type.PASSAGE);
        visitedCells.add(maze.getGrid()[x][y]);

        while (!visitedCells.isEmpty()) {
            int indexCell = random.nextInt(visitedCells.size());
            List<Cell> neighbors = getUnvisitedNeighbors(maze, visitedCells.get(indexCell));
            if (!neighbors.isEmpty()) {
                int index = random.nextInt(neighbors.size());
                createPassage(maze, visitedCells.get(indexCell), neighbors.get(index));
                visitedCells.add(neighbors.get(index));
            } else {
                visitedCells.remove(indexCell);
            }
        }
        return maze;
    }
}
