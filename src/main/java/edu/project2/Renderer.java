package edu.project2;

import edu.project2.gameObject.Cell;
import edu.project2.gameObject.Coordinate;
import edu.project2.gameObject.Maze;
import edu.project2.gameObject.Type;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Renderer {
    //'▩' '▢' '◈'

    public String render(Maze maze) {
        StringBuilder result = new StringBuilder();
        for (Cell[] cells: maze.getGrid()) {
            for (Cell cell: cells) {
                result.append(cell.getType() == Type.PASSAGE ? '▢' : '▩');
            }
            result.append("\n");
        }
        return result.toString();
    }

    public String render(Maze maze, List<Coordinate> path) {
        Set<Coordinate> set = new HashSet<>(path);
        StringBuilder result = new StringBuilder();
        for (Cell[] cells: maze.getGrid()) {
            for (Cell cell: cells) {
                if (set.contains(cell.getCoordinate())) {
                    result.append('◈');
                } else {
                    result.append(cell.getType() == Type.PASSAGE ? '▢' : '▩');
                }
            }
            result.append("\n");
        }
        return result.toString();
    }
}
