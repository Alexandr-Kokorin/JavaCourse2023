package edu.project5;

import java.lang.invoke.LambdaMetafactory;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Method;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

@State(Scope.Benchmark)
public class ReflectionBenchmark {

    private static final String METHOD_NAME = "name";
    private final Student student;
    private Method method;
    private MethodHandle methodHandle;
    private NameGetter getter;

    public ReflectionBenchmark() {
        student = new Student("Alexandr", "Kokorin");
        initMethod();
        initMethodHandle();
        initNameGetter();
    }

    private void initMethod() {
        try {
            method = Student.class.getMethod(METHOD_NAME);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    private void initMethodHandle() {
        try {
            MethodHandles.Lookup lookup = MethodHandles.lookup();
            methodHandle = lookup.findVirtual(Student.class, METHOD_NAME, MethodType.methodType(String.class));
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    private void initNameGetter() {
        try {
            var caller = MethodHandles.lookup();
            var factoryType = MethodType.methodType(NameGetter.class);
            var interfaceMethodType = MethodType.methodType(String.class, Student.class);
            var implementation = caller.findVirtual(Student.class, METHOD_NAME, MethodType.methodType(String.class));
            var dynamic = MethodType.methodType(String.class, Student.class);

            getter = (NameGetter) LambdaMetafactory.metafactory(
                caller,
                "get",
                factoryType,
                interfaceMethodType,
                implementation,
                dynamic
            ).getTarget().invokeExact();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    @Benchmark
    public String directAccess() {
        return student.name();
    }

    @Benchmark
    public String reflectMethod() throws Exception {
        return (String) method.invoke(student);
    }

    @Benchmark
    public String methodHandles() throws Throwable {
        return (String) methodHandle.invoke(student);
    }

    @Benchmark
    public String lambdaMetafactory() {
        return getter.get(student);
    }
}
