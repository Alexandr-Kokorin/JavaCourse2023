package edu.hw2.task3;

import edu.hw2.task3.connectionManagers.DefaultConnectionManager;
import edu.hw2.task3.connectionManagers.FaultyConnectionManager;

public final class Main {

    private static final int MAX_ATTEMPTS = 5;

    private Main() {}

    public static void main(String[] args) {
        var connectionManagerDefault = new DefaultConnectionManager();
        var connectionManagerFaulty = new FaultyConnectionManager();

        var popularCommandExecutorDefault = new PopularCommandExecutor(connectionManagerDefault, MAX_ATTEMPTS);
        popularCommandExecutorDefault.updatePackages();

        var popularCommandExecutorFaulty = new PopularCommandExecutor(connectionManagerFaulty, MAX_ATTEMPTS);
        popularCommandExecutorFaulty.updatePackages();

    }
}
