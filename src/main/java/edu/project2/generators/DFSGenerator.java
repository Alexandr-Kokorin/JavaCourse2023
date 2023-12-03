package edu.project2.generators;

import edu.project2.gameObject.Cell;
import edu.project2.gameObject.Maze;
import edu.project2.gameObject.Type;
import java.util.List;
import java.util.Random;
import java.util.Stack;

public class DFSGenerator implements Generator {

    @Override
    public Maze generate(int height, int width) {
        if (height < MIN_SIZE || width < MIN_SIZE) {
            return new Maze(0, 0);
        }

        Random random = new Random(System.currentTimeMillis());
        Maze maze = new Maze(height, width);
        setAllWall(maze);

        Stack<Cell> visitedCells = new Stack<>();
        maze.getGrid()[1][1].setType(Type.PASSAGE);
        visitedCells.push(maze.getGrid()[1][1]);

        while (!visitedCells.isEmpty()) {
            List<Cell> neighbors = getUnvisitedNeighbors(maze, visitedCells.peek());
            if (!neighbors.isEmpty()) {
                int index = random.nextInt(neighbors.size());
                createPassage(maze, visitedCells.peek(), neighbors.get(index));
                visitedCells.push(neighbors.get(index));
            } else {
                visitedCells.pop();
            }
        }
        return maze;
    }
}
