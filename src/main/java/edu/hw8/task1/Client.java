package edu.hw8.task1;

import java.io.IOException;
import java.net.Socket;

public class Client {

    private static final String ADDRESS = "localhost";
    private final Connector connector;

    public Client(int port) {
        try {
            Socket socket = new Socket(ADDRESS, port);
            connector = new Connector(socket);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void write(String string) throws IOException {
        connector.writeLine(string);
    }

    public String read() throws IOException {
        return connector.readLine();
    }
}
