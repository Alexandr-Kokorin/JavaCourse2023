package edu.project2;

import edu.project2.gameObject.Coordinate;
import edu.project2.gameObject.Maze;
import edu.project2.gameObject.Type;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RendererTest {
    //'▩' '▢' '◈'

    private final Renderer renderer = new Renderer();

    @Test
    @DisplayName("TestRender - \"maze\", expected - \"true\"")
    void RenderTest1() {
        String string = """
            ▩▩▩▩▩▩▩▩▩▩
            ▩▢▢▩▩▩▢▩▩▩
            ▩▩▢▢▢▢▢▢▩▩
            ▩▩▩▩▢▩▩▢▩▩
            ▩▩▩▩▩▩▩▩▩▩
                        """;

        Maze maze = new Maze(5, 10);
        for (int i = 0; i < maze.getHeight(); i++) {
            for (int j = 0; j < maze.getWidth(); j++) {
                maze.addCell(i, j, Type.WALL);
            }
        }
        maze.addCell(1, 1, Type.PASSAGE);
        maze.addCell(1, 2, Type.PASSAGE);
        maze.addCell(1, 6, Type.PASSAGE);
        maze.addCell(2, 2, Type.PASSAGE);
        maze.addCell(2, 3, Type.PASSAGE);
        maze.addCell(2, 4, Type.PASSAGE);
        maze.addCell(2, 5, Type.PASSAGE);
        maze.addCell(2, 6, Type.PASSAGE);
        maze.addCell(2, 7, Type.PASSAGE);
        maze.addCell(3, 4, Type.PASSAGE);
        maze.addCell(3, 7, Type.PASSAGE);

        String result = renderer.render(maze);

        assertThat(result).isEqualTo(string);
    }

    @Test
    @DisplayName("TestRender - \"maze, path\", expected - \"true\"")
    void RenderTest2() {
        String string = """
            ▩▩▩▩▩▩▩▩▩▩
            ▩◈◈▩▩▩▢▩▩▩
            ▩▩◈◈◈▢▢▢▩▩
            ▩▩▩▩◈▩▩▢▩▩
            ▩▩▩▩▩▩▩▩▩▩
                        """;

        Maze maze = new Maze(5, 10);
        for (int i = 0; i < maze.getHeight(); i++) {
            for (int j = 0; j < maze.getWidth(); j++) {
                maze.addCell(i, j, Type.WALL);
            }
        }
        maze.addCell(1, 1, Type.PASSAGE);
        maze.addCell(1, 2, Type.PASSAGE);
        maze.addCell(1, 6, Type.PASSAGE);
        maze.addCell(2, 2, Type.PASSAGE);
        maze.addCell(2, 3, Type.PASSAGE);
        maze.addCell(2, 4, Type.PASSAGE);
        maze.addCell(2, 5, Type.PASSAGE);
        maze.addCell(2, 6, Type.PASSAGE);
        maze.addCell(2, 7, Type.PASSAGE);
        maze.addCell(3, 4, Type.PASSAGE);
        maze.addCell(3, 7, Type.PASSAGE);

        List<Coordinate> path = new ArrayList<>();
        path.add(new Coordinate(1, 1));
        path.add(new Coordinate(1, 2));
        path.add(new Coordinate(2, 2));
        path.add(new Coordinate(2, 3));
        path.add(new Coordinate(2, 4));
        path.add(new Coordinate(3, 4));

        String result = renderer.render(maze, path);

        assertThat(result).isEqualTo(string);
    }

    @Test
    @DisplayName("TestRender - \"maze 0\", expected - \"true\"")
    void RenderTest3() {
        Maze maze = new Maze(0, 0);

        String result = renderer.render(maze);

        assertThat(result).isEqualTo("");
    }

    @Test
    @DisplayName("TestRender - \"maze, path 0\", expected - \"true\"")
    void RenderTest4() {
        String string = """
            ▩▩▩▩▩▩▩▩▩▩
            ▩▢▢▩▩▩▢▩▩▩
            ▩▩▢▢▢▢▢▢▩▩
            ▩▩▩▩▢▩▩▢▩▩
            ▩▩▩▩▩▩▩▩▩▩
                        """;

        Maze maze = new Maze(5, 10);
        for (int i = 0; i < maze.getHeight(); i++) {
            for (int j = 0; j < maze.getWidth(); j++) {
                maze.addCell(i, j, Type.WALL);
            }
        }
        maze.addCell(1, 1, Type.PASSAGE);
        maze.addCell(1, 2, Type.PASSAGE);
        maze.addCell(1, 6, Type.PASSAGE);
        maze.addCell(2, 2, Type.PASSAGE);
        maze.addCell(2, 3, Type.PASSAGE);
        maze.addCell(2, 4, Type.PASSAGE);
        maze.addCell(2, 5, Type.PASSAGE);
        maze.addCell(2, 6, Type.PASSAGE);
        maze.addCell(2, 7, Type.PASSAGE);
        maze.addCell(3, 4, Type.PASSAGE);
        maze.addCell(3, 7, Type.PASSAGE);

        List<Coordinate> path = List.of();

        String result = renderer.render(maze, path);

        assertThat(result).isEqualTo(string);
    }
}
