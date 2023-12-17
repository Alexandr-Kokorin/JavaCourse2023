package edu.hw11;

import edu.hw11.task2.ArithmeticUtils;
import edu.hw11.task2.ArithmeticUtilsReload;
import net.bytebuddy.ByteBuddy;
import net.bytebuddy.agent.ByteBuddyAgent;
import net.bytebuddy.dynamic.loading.ClassReloadingStrategy;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task2Test {

    @Test
    void arithmeticUtilsTest() {
        ByteBuddyAgent.install();
        ArithmeticUtils arithmeticUtils = new ArithmeticUtils();
        new ByteBuddy()
            .redefine(ArithmeticUtilsReload.class)
            .name(ArithmeticUtils.class.getName())
            .make()
            .load(ArithmeticUtils.class.getClassLoader(), ClassReloadingStrategy.fromInstalledAgent());
        assertThat(arithmeticUtils.sum(3, 4)).isEqualTo(12);
    }
}
