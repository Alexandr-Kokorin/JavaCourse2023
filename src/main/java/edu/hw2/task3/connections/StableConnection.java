package edu.hw2.task3.connections;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class StableConnection implements Connection {

    private final static Logger LOGGER = LogManager.getLogger();
    private boolean isSuccess;

    @Override
    public void execute(String command) {
        isSuccess = false;
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
