package edu.project3;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.io.File;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PathTest {

    static Arguments[] paths() {
        return new Arguments[] {
            Arguments.of(
                "logs" + File.separator + "2015-05-24.txt",
                List.of("logs" + File.separator + "2015-05-24.txt")
            ),
            Arguments.of(
                "logs" + File.separator + "2015*",
                List.of("logs" + File.separator + "2015-05-24.txt", "logs" + File.separator + "2015-05-25.txt")
            ),
            Arguments.of(
                "https://raw.githubusercontent.com/elastic/examples/master/Common%20Data%20Formats/nginx_logs/nginx_logs",
                List.of(
                    "https://raw.githubusercontent.com/elastic/examples/master/Common%20Data%20Formats/nginx_logs/nginx_logs")
            ),
        };
    }

    @ParameterizedTest
    @MethodSource("paths")
    void pathTest(String path, List<String> excepted) {
        var result = Main.getPaths(path);

        assertThat(result).isEqualTo(excepted);
    }
}
