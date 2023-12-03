package edu.project2;

import edu.project2.gameObject.Coordinate;
import edu.project2.gameObject.Maze;
import edu.project2.generators.DFSGenerator;
import edu.project2.generators.Generator;
import edu.project2.generators.PrimsGenerator;
import edu.project2.solvers.BFSSolver;
import edu.project2.solvers.DFSSolver;
import edu.project2.solvers.Solver;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public final class Main {

    private Main() {}

    @SuppressWarnings({"MagicNumber", "RegexpSinglelineJava"})
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random(System.currentTimeMillis());
        Renderer renderer = new Renderer();

        System.out.println("Выберите генератор:\n1) DFS\n2) Prims");
        Generator generator = switch (scanner.nextInt()) {
            case 1 -> new DFSGenerator();
            case 2 -> new PrimsGenerator();
            default -> random.nextInt(1, 3) == 1 ? new DFSGenerator() : new PrimsGenerator();
        };

        System.out.println("Выберите решатель:\n1) DFS\n2) BFS");
        Solver solver = switch (scanner.nextInt()) {
            case 1 -> new DFSSolver();
            case 2 -> new BFSSolver();
            default -> random.nextInt(1, 3) == 1 ? new DFSSolver() : new BFSSolver();
        };

        System.out.println("Введите высоту и ширину лабиринта:");
        Maze maze = generator.generate(scanner.nextInt(), scanner.nextInt());
        System.out.println(renderer.render(maze));

        System.out.println("Введите начальные координаты:");
        Coordinate begin = new Coordinate(scanner.nextInt(), scanner.nextInt());
        System.out.println("Введите конечные координаты:");
        Coordinate end = new Coordinate(scanner.nextInt(), scanner.nextInt());

        List<Coordinate> path = solver.solve(maze, begin, end);
        System.out.println(renderer.render(maze, path));
    }
}
