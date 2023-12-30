package edu.hw8.task1;

import java.io.IOException;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class ClientHandler extends Thread {

    private final Connector connector;
    private final Map<String, String> dictionary;

    public ClientHandler(Socket socket) {
        try {
            connector = new Connector(socket);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        dictionary = new HashMap<>();
        dictionary.put("личности", "Не переходи на личности там, где их нет.");
        dictionary.put(
            "оскорбления",
            "Если твои противники перешли на личные оскорбления, будь уверена — твоя победа не за горами."
        );
        dictionary.put(
            "глупый",
            "А я тебе говорил, что ты глупый? Так вот, я забираю свои слова обратно... Ты просто бог идиотизма."
        );
        dictionary.put("интеллект", "Чем ниже интеллект, тем громче оскорбления.");
    }

    @Override
    public void run() {
        while (true) {
            try {
                String line = connector.readLine();
                connector.writeLine(dictionary.get(line));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
