package edu.hw2.task3;

public class ConnectionException extends RuntimeException {

    public ConnectionException() {}

    public ConnectionException(Exception e) {
        this.initCause(e);
    }
}
