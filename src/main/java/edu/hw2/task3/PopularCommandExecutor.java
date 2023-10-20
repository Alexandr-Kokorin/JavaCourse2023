package edu.hw2.task3;

import edu.hw2.task3.connectionManagers.ConnectionManager;
import edu.hw2.task3.connections.Connection;

public final class PopularCommandExecutor {
    private final ConnectionManager manager;
    private final int maxAttempts;

    public PopularCommandExecutor(ConnectionManager manager, int maxAttempts) {
        this.manager = manager;
        this.maxAttempts = maxAttempts;
    }

    public void updatePackages() {
        tryExecute("apt update && apt upgrade -y");
    }

    void tryExecute(String command) {
        try (Connection connection = manager.getConnection()) {
            for (int i = 0; i < maxAttempts; i++) {
                connection.execute(command);
            }
        } catch (Exception e) {
            throw new ConnectionException(e);
        }
    }
}
