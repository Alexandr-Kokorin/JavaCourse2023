package edu.hw7;

import edu.hw7.task3.DatabaseWithReadWriteLock;
import edu.hw7.task3.DatabaseWithSynchronized;
import edu.hw7.task3.Person;
import edu.hw7.task3.PersonDatabase;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task3Test {

    static Arguments[] databaseTestData() {
        return new Arguments[] {
            Arguments.of(new DatabaseWithSynchronized()),
            Arguments.of(new DatabaseWithReadWriteLock())
        };
    }

    @ParameterizedTest
    @MethodSource("databaseTestData")
    void databaseTest(PersonDatabase database) {

        new Thread(() -> {
            database.add(new Person(1, "fgd", "rtsh", "3224"));
            database.add(new Person(2, "rtew", "qwfg", "6544"));
            database.add(new Person(3, "jgf", "rxdu", "7833"));
            database.delete(2);
        }).start();

        new Thread(() -> {
            boolean flag;

            boolean p1 = database.findByName("fgd").isEmpty();
            boolean p2 = database.findByPhone("3224").isEmpty();
            boolean p3 = database.findByAddress("rtsh").isEmpty();
            flag = p1 && p2 && p3 || !p1 && !p2 && !p3;

            p1 = database.findByName("rtew").isEmpty();
            p2 = database.findByPhone("6544").isEmpty();
            p3 = database.findByAddress("qwfg").isEmpty();
            flag = flag && (p1 && p2 && p3 || !p1 && !p2 && !p3);

            p1 = database.findByName("jgf").isEmpty();
            p2 = database.findByPhone("7833").isEmpty();
            p3 = database.findByAddress("rxdu").isEmpty();
            flag = flag && (p1 && p2 && p3 || !p1 && !p2 && !p3);

            assertThat(flag).isTrue();
        }).start();
    }
}
