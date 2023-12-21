package edu.hw8.task1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Connector implements Closeable {

    private final BufferedReader reader;
    private final BufferedWriter writer;

    public Connector(Socket socket) throws IOException {
        reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
    }

    public String readLine() throws IOException {
        return reader.readLine();
    }

    public void writeLine(String str) throws IOException {
        writer.write(str);
        writer.newLine();
        writer.flush();
    }

    public void close() throws IOException {
        reader.close();
        writer.close();
    }
}
