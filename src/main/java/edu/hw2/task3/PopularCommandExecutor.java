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
        ConnectionException exception = null;
        try(Connection connection = manager.getConnection()) {
            for (int i = 0; i < maxAttempts; i++) {
                try {
                    connection.execute(command);
                    return;
                } catch (ConnectionException e) {
                    exception = e;
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        throw new ConnectionException(exception);
    }
}
