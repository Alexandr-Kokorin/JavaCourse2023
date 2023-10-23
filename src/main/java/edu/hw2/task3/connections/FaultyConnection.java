package edu.hw2.task3.connections;

import edu.hw2.task3.ConnectionException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FaultyConnection implements Connection {

    private final static Logger LOGGER = LogManager.getLogger();
    private static final float CHANCE_OF_ERROR = 0.3f;

    private boolean isSuccess;

    @Override
    public void execute(String command) {
        isSuccess = false;
        if (Math.random() < CHANCE_OF_ERROR) {
            throw new ConnectionException();
        }
        doWork();
    }

    private void doWork() {
        LOGGER.info("Exactly");
        isSuccess = true;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    @Override
    public void close() throws Exception {}
}
