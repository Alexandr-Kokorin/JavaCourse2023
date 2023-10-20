package edu.hw2.task4;

public final class Task4 {

    private Task4() {}

    public static CallingInfo callingInfo() {
        StackTraceElement element = Thread.currentThread().getStackTrace()[2];
        String className = element.getClassName();
        String methodName = element.getMethodName();
        return new CallingInfo(className, methodName);
    }
}
