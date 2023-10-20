package edu.hw2;

import edu.hw2.task3.connectionManagers.DefaultConnectionManager;
import edu.hw2.task3.connectionManagers.FaultyConnectionManager;
import edu.hw2.task3.connections.FaultyConnection;
import edu.hw2.task3.connections.StableConnection;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DisplayName("TestConnections")
public class Task3Test {

    @Test
    @DisplayName("Test - \"DefaultConnectionManager\", expected - \"FaultyConnection || StableConnection\"")
    void ConnectionsTest1() {
        var connectionManager = new DefaultConnectionManager();

        var connection = connectionManager.getConnection();

        assertThat(connection).isInstanceOfAny(FaultyConnection.class, StableConnection.class);
    }

    @Test
    @DisplayName("Test - \"FaultyConnectionManager\", expected - \"FaultyConnection\"")
    void ConnectionsTest2() {
        var connectionManager = new FaultyConnectionManager();

        var connection = connectionManager.getConnection();

        assertThat(connection).isInstanceOfAny(FaultyConnection.class);
    }

}
