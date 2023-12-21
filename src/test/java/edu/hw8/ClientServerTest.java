package edu.hw8;

import edu.hw8.task1.Client;
import edu.hw8.task1.Server;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ClientServerTest {

    @Test
    void clientServerTest() throws IOException {
        Server server = new Server(8080, 3);
        server.start();
        Client client = new Client(8080);
        client.write("личности");
        var result = client.read();
        server.close();

        assertThat(result).isEqualTo("Не переходи на личности там, где их нет.");
    }
}
