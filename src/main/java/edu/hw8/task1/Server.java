package edu.hw8.task1;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server extends Thread {

    private final int countThreads;
    private final ServerSocket serverSocket;
    private boolean stopFlag;

    public Server(int port, int countThreads) {
        this.countThreads = countThreads;
        stopFlag = false;
        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {
        try (ExecutorService executorService = Executors.newFixedThreadPool(countThreads);) {
            while (!stopFlag) {
                Socket clientSocket = serverSocket.accept();
                executorService.execute(new ClientHandler(clientSocket));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void close() {
        stopFlag = true;
    }
}
