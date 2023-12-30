package edu.hw11;

import edu.hw11.task3.FibonacciAppender;
import net.bytebuddy.ByteBuddy;
import net.bytebuddy.implementation.Implementation;
import org.junit.jupiter.api.Test;
import org.objectweb.asm.Opcodes;
import java.lang.reflect.InvocationTargetException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task3Test {

    @Test
    void fibonacciTest() throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Class<?> dynamicClass = new ByteBuddy()
            .subclass(Object.class)
            .name("Fibonacci")
            .defineMethod("fib", long.class, Opcodes.ACC_PUBLIC | Opcodes.ACC_STATIC)
            .withParameter(int.class, "n")
            .intercept(new Implementation.Simple(new FibonacciAppender()))
            .make()
            .load(getClass().getClassLoader())
            .getLoaded();
        assertThat((long) dynamicClass.getMethod("fib", int.class).invoke(null, 5)).isEqualTo(5);
    }
}
