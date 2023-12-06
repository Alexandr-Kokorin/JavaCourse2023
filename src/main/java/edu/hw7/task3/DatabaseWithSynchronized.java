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
        return findBy(Type.NAME, name);
    }

    @Override
    public synchronized List<Person> findByAddress(String address) {
        return findBy(Type.ADDRESS, address);
    }

    @Override
    public synchronized List<Person> findByPhone(String phone) {
        return findBy(Type.PHONE, phone);
    }

    private List<Person> findBy(Type type, String string) {
        List<Person> persons = new ArrayList<>();
        for (int id : database.keySet()) {
            String value = switch (type) {
                case NAME -> database.get(id).name();
                case ADDRESS -> database.get(id).address();
                case PHONE -> database.get(id).phoneNumber();
            };
            if (value.equals(string)) {
                persons.add(database.get(id));
            }
        }
        return persons;
    }
}
