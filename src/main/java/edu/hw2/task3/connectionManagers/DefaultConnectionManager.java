package edu.hw2.task3.connectionManagers;

import edu.hw2.task3.connections.Connection;
import edu.hw2.task3.connections.FaultyConnection;
import edu.hw2.task3.connections.StableConnection;

public class DefaultConnectionManager implements ConnectionManager {

    private static final float CHANCE_OF_FAULTY_CONNECTION = 0.4f;

    @Override
    public Connection getConnection() {
        return Math.random() < CHANCE_OF_FAULTY_CONNECTION ? new FaultyConnection() : new StableConnection();
    }
}
