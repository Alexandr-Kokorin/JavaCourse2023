package edu.hw3;

import edu.hw3.task1.Task1;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DisplayName("TestAtbash")
public class Task1Test {

    static Arguments[] atbashTestData() {
        return new Arguments[]{
            Arguments.of(
                "Hello world!",
                "Svool dliow!"
            ),
            Arguments.of(
                "Any fool can write code that a computer can understand. Good programmers write code that humans can understand. ― Martin Fowler",
                "Zmb ullo xzm dirgv xlwv gszg z xlnkfgvi xzm fmwvihgzmw. Tllw kiltiznnvih dirgv xlwv gszg sfnzmh xzm fmwvihgzmw. ― Nzigrm Uldovi"
            ),
            Arguments.of(
                "",
                ""
            ),
            Arguments.of(
                null,
                ""
            )
        };
    }

    @ParameterizedTest
    @MethodSource("atbashTestData")
    void atbash_ResultShouldMatchExpected(String test, String expected) {
        String result = Task1.atbash(test);

        assertThat(result).isEqualTo(expected);
    }
}
