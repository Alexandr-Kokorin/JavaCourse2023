package edu.project2;

import edu.project2.gameObject.Maze;
import edu.project2.generators.DFSGenerator;
import edu.project2.generators.Generator;
import edu.project2.generators.PrimsGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class GeneratorTest {

    static Arguments[] generators() {
        return new Arguments[]{
            Arguments.of(new DFSGenerator()),
            Arguments.of(new PrimsGenerator())
        };
    }

    @ParameterizedTest
    @MethodSource("generators")
    void generateNormal(Generator generator) {
        Maze maze = generator.generate(10, 10);

        int height = maze.getHeight();
        int width = maze.getWidth();

        assertThat(height).isEqualTo(10);
        assertThat(width).isEqualTo(10);
    }

    @ParameterizedTest
    @MethodSource("generators")
    void generateFail(Generator generator) {
        Maze maze = generator.generate(-1, -1);

        int height = maze.getHeight();
        int width = maze.getWidth();

        assertThat(height).isEqualTo(0);
        assertThat(width).isEqualTo(0);
    }
}
