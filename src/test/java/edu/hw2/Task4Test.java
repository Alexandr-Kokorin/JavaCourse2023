package edu.hw2;

import edu.hw2.task4.Task4;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DisplayName("TestCallingInfo")
public class Task4Test {

    @Test
    @DisplayName("Test - \"class\", expected - \"edu.hw2.Task4Test\"")
    void callingInfoTest1() {
        var callingInfo = Task4.callingInfo();
        String className = "edu.hw2.Task4Test";

        String classNameTest = callingInfo.className();

        assertThat(classNameTest).isEqualTo(className);
    }

    @Test
    @DisplayName("Test - \"method\", expected - \"callingInfoTest2\"")
    void callingInfoTest2() {
        var callingInfo = Task4.callingInfo();
        String methodName = "callingInfoTest2";

        String methodNameTest = callingInfo.methodName();

        assertThat(methodNameTest).isEqualTo(methodName);
    }
}
