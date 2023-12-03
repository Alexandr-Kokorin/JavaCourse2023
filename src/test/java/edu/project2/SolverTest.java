package edu.project2;

import edu.project2.gameObject.Coordinate;
import edu.project2.gameObject.Maze;
import edu.project2.gameObject.Type;
import edu.project2.solvers.BFSSolver;
import edu.project2.solvers.DFSSolver;
import edu.project2.solvers.Solver;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SolverTest {

    static Arguments[] solvers() {
        return new Arguments[]{
            Arguments.of(new DFSSolver()),
            Arguments.of(new BFSSolver())
        };
    }

    @ParameterizedTest
    @MethodSource("solvers")
    void solverNormal(Solver solver) {
         /* ▩▩▩▩▩▩▩▩▩▩
            ▩◈◈▩▩▩◈▩▩▩
            ▩▩◈◈◈◈◈▢▩▩
            ▩▩▩▩▢▩▩▢▩▩
            ▩▩▩▩▩▩▩▩▩▩ */

        Maze maze = new Maze(5, 10);
        for (int i = 0; i < maze.getHeight(); i++) {
            for (int j = 0; j < maze.getWidth(); j++) {
                maze.setCell(i, j, Type.WALL);
            }
        }
        maze.setCell(1, 1, Type.PASSAGE);
        maze.setCell(1, 2, Type.PASSAGE);
        maze.setCell(1, 6, Type.PASSAGE);
        maze.setCell(2, 2, Type.PASSAGE);
        maze.setCell(2, 3, Type.PASSAGE);
        maze.setCell(2, 4, Type.PASSAGE);
        maze.setCell(2, 5, Type.PASSAGE);
        maze.setCell(2, 6, Type.PASSAGE);
        maze.setCell(2, 7, Type.PASSAGE);
        maze.setCell(3, 4, Type.PASSAGE);
        maze.setCell(3, 7, Type.PASSAGE);

        List<Coordinate> truePath = new ArrayList<>();
        truePath.add(new Coordinate(1, 1));
        truePath.add(new Coordinate(1, 2));
        truePath.add(new Coordinate(2, 2));
        truePath.add(new Coordinate(2, 3));
        truePath.add(new Coordinate(2, 4));
        truePath.add(new Coordinate(2, 5));
        truePath.add(new Coordinate(2, 6));
        truePath.add(new Coordinate(1, 6));

        List<Coordinate> path = solver.solve(maze, new Coordinate(1, 1), new Coordinate(1, 6));

        assertThat(path.toArray()).containsExactly(truePath.toArray());
    }

    @ParameterizedTest
    @MethodSource("solvers")
    void solverFail1(Solver solver) {
        Maze maze = new Maze(5, 10);
        for (int i = 0; i < maze.getHeight(); i++) {
            for (int j = 0; j < maze.getWidth(); j++) {
                maze.setCell(i, j, Type.WALL);
            }
        }
        maze.setCell(1, 1, Type.PASSAGE);
        maze.setCell(1, 2, Type.PASSAGE);
        maze.setCell(1, 6, Type.PASSAGE);
        maze.setCell(2, 2, Type.PASSAGE);
        maze.setCell(2, 3, Type.PASSAGE);
        maze.setCell(2, 4, Type.PASSAGE);
        maze.setCell(2, 5, Type.PASSAGE);
        maze.setCell(2, 6, Type.PASSAGE);
        maze.setCell(2, 7, Type.PASSAGE);
        maze.setCell(3, 4, Type.PASSAGE);
        maze.setCell(3, 7, Type.PASSAGE);

        List<Coordinate> truePath = List.of();

        List<Coordinate> path = solver.solve(maze, new Coordinate(1, 3), new Coordinate(3, 4));

        assertThat(path.toArray()).containsExactly(truePath.toArray());
    }

    @ParameterizedTest
    @MethodSource("solvers")
    void solverFail2(Solver solver) {
        Maze maze = new Maze(5, 10);
        for (int i = 0; i < maze.getHeight(); i++) {
            for (int j = 0; j < maze.getWidth(); j++) {
                maze.setCell(i, j, Type.WALL);
            }
        }
        maze.setCell(1, 1, Type.PASSAGE);
        maze.setCell(1, 2, Type.PASSAGE);
        maze.setCell(1, 6, Type.PASSAGE);
        maze.setCell(2, 2, Type.PASSAGE);
        maze.setCell(2, 3, Type.PASSAGE);
        maze.setCell(2, 4, Type.PASSAGE);
        maze.setCell(2, 5, Type.PASSAGE);
        maze.setCell(2, 6, Type.PASSAGE);
        maze.setCell(2, 7, Type.PASSAGE);
        maze.setCell(3, 4, Type.PASSAGE);
        maze.setCell(3, 7, Type.PASSAGE);

        List<Coordinate> truePath = List.of();

        List<Coordinate> path = solver.solve(maze, new Coordinate(1, 1), new Coordinate(3, 3));

        assertThat(path.toArray()).containsExactly(truePath.toArray());
    }

    @ParameterizedTest
    @MethodSource("solvers")
    void solverFail3(Solver solver) {
        Maze maze = new Maze(0, 0);
        List<Coordinate> truePath = List.of();

        List<Coordinate> path = solver.solve(maze, new Coordinate(1, 1), new Coordinate(3, 4));

        assertThat(path.toArray()).containsExactly(truePath.toArray());
    }

    @ParameterizedTest
    @MethodSource("solvers")
    void solverFail4(Solver solver) {
         /* ▩▩▩▩▩▩▩▩▩▩
            ▩▢▢▩▩▩▢▩▩▩
            ▩▩▢▩▢▢▢▢▩▩
            ▩▩▩▩▢▩▩▢▩▩
            ▩▩▩▩▩▩▩▩▩▩ */

        Maze maze = new Maze(5, 10);
        for (int i = 0; i < maze.getHeight(); i++) {
            for (int j = 0; j < maze.getWidth(); j++) {
                maze.setCell(i, j, Type.WALL);
            }
        }
        maze.setCell(1, 1, Type.PASSAGE);
        maze.setCell(1, 2, Type.PASSAGE);
        maze.setCell(1, 6, Type.PASSAGE);
        maze.setCell(2, 2, Type.PASSAGE);
        maze.setCell(2, 4, Type.PASSAGE);
        maze.setCell(2, 5, Type.PASSAGE);
        maze.setCell(2, 6, Type.PASSAGE);
        maze.setCell(2, 7, Type.PASSAGE);
        maze.setCell(3, 4, Type.PASSAGE);
        maze.setCell(3, 7, Type.PASSAGE);

        List<Coordinate> truePath = List.of();

        List<Coordinate> path = solver.solve(maze, new Coordinate(1, 1), new Coordinate(1, 6));

        assertThat(path.toArray()).containsExactly(truePath.toArray());
    }
}
