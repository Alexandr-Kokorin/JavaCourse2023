package edu.hw2;

import edu.hw2.task3.ConnectionException;
import edu.hw2.task3.PopularCommandExecutor;
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

        assertThat(connection).isInstanceOf(FaultyConnection.class);
    }

    @Test
    @DisplayName("Test - \"StableConnection\", expected - \"true\"")
    void ConnectionsTest3() {
        try(var connection = new StableConnection()) {
            connection.execute("command");
            var result = connection.isSuccess();

            assertThat(result).isEqualTo(true);
        } catch (Exception e) {}
    }

    @Test
    @DisplayName("Test - \"FaultyConnection\", expected - \"true || ConnectionException\"")
    void ConnectionsTest4() {
        try(var connection = new FaultyConnection()) {
            connection.execute("command");
            var result = connection.isSuccess();

            assertThat(result).isEqualTo(true);
        } catch (Exception e) {
            assertThat(e).isInstanceOf(ConnectionException.class);
        }

    }

    @Test
    @DisplayName("Test - \"PopularCommandExecutor\", expected - \"true || ConnectionException\"")
    void ConnectionsTest5() {
        var connectionManager = new FaultyConnectionManager();
        try {
            var popularCommandExecutor = new PopularCommandExecutor(connectionManager, 5);
            popularCommandExecutor.updatePackages();

            assertThat(true).isEqualTo(true);
        } catch (Exception e) {
            assertThat(e).isInstanceOf(ConnectionException.class);
        }
    }

}
