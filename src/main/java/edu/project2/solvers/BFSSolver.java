package edu.project2.solvers;

import edu.project2.gameObject.Coordinate;
import edu.project2.gameObject.Maze;
import edu.project2.gameObject.Type;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BFSSolver implements Solver {

    @Override
    public List<Coordinate> solve(Maze maze, Coordinate start, Coordinate end) {
        if (maze.getHeight() == 0 || maze.getWidth() == 0
            || maze.getGrid()[start.row()][start.col()].getType() == Type.WALL
            || maze.getGrid()[end.row()][end.col()].getType() == Type.WALL) {
            return List.of();
        }

        Set<Coordinate> visitedCells = new HashSet<>();
        List<List<Coordinate>> paths = new ArrayList<>();

        visitedCells.add(maze.getGrid()[start.row()][start.col()].getCoordinate());
        paths.add(new ArrayList<>());
        paths.get(0).add(maze.getGrid()[start.row()][start.col()].getCoordinate());

        boolean stopFlag = false;
        while (!stopFlag) {
            stopFlag = true;
            int size = paths.size();
            for (int i = 0; i < size; i++) {
                List<Coordinate> list = paths.get(i);
                List<Coordinate> neighbors = getUnvisitedNeighbors(maze, list.get(list.size() - 1), visitedCells);
                if (!neighbors.isEmpty()) {
                    stopFlag = false;
                    list.add(neighbors.get(0));
                    visitedCells.add(neighbors.get(0));
                    if (list.get(list.size() - 1).equals(end)) {
                        return list;
                    }
                    if (neighbors.size() > 1) {
                        for (int j = 1; j < neighbors.size(); j++) {
                            paths.add(new ArrayList<>(list));
                            paths.get(paths.size() - 1).remove(paths.get(paths.size() - 1).size() - 1);
                            paths.get(paths.size() - 1).add(neighbors.get(j));
                            visitedCells.add(neighbors.get(j));
                            if (paths.get(paths.size() - 1).get(paths.get(paths.size() - 1).size() - 1).equals(end)) {
                                return paths.get(paths.size() - 1);
                            }
                        }
                    }
                }
            }
        }
        return List.of();
    }
}
