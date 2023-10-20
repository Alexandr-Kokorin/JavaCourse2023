package edu.hw2;

import edu.hw2.task4.Task4;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DisplayName("TestCallingInfo")
public class Task4Test {

    @Test
    @DisplayName("Test - \"equals\", expected - \"true\"")
    void callingInfoTest() {
        var callingInfo1 = Task4.callingInfo();
        var callingInfo2 = Task4.callingInfo();

        assertThat(callingInfo1).isEqualTo(callingInfo2);
    }
}
