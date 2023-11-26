package edu.hw7.task3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DatabaseWithSynchronized implements PersonDatabase {

    private final Map<Integer, Person> database = new HashMap<>();

    @Override
    public synchronized void add(Person person) {
        database.put(person.id(), person);
    }

    @Override
    public synchronized void delete(int id) {
        database.remove(id);
    }

    @Override
    public synchronized List<Person> findByName(String name) {
        List<Person> persons = new ArrayList<>();
        for (int id : database.keySet()) {
            if (database.get(id).name().equals(name)) {
                persons.add(database.get(id));
            }
        }
        return persons;
    }

    @Override
    public synchronized List<Person> findByAddress(String address) {
        List<Person> persons = new ArrayList<>();
        for (int id : database.keySet()) {
            if (database.get(id).address().equals(address)) {
                persons.add(database.get(id));
            }
        }
        return persons;
    }

    @Override
    public synchronized List<Person> findByPhone(String phone) {
        List<Person> persons = new ArrayList<>();
        for (int id : database.keySet()) {
            if (database.get(id).phoneNumber().equals(phone)) {
                persons.add(database.get(id));
            }
        }
        return persons;
    }
}
