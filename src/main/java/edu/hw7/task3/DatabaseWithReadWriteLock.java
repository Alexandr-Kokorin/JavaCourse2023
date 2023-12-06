package edu.hw7.task3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class DatabaseWithReadWriteLock implements PersonDatabase {

    private final Map<Integer, Person> database = new HashMap<>();
    private final ReadWriteLock lock = new ReentrantReadWriteLock();

    @Override
    public void add(Person person) {
        try {
            lock.writeLock().lock();
            database.put(person.id(), person);
        } finally {
            lock.writeLock().unlock();
        }
    }

    @Override
    public void delete(int id) {
        try {
            lock.writeLock().lock();
            database.remove(id);
        } finally {
            lock.writeLock().unlock();
        }
    }

    @Override
    public List<Person> findByName(String name) {
        List<Person> persons;
        try {
            lock.readLock().lock();
            persons = findBy(Type.NAME, name);
        } finally {
            lock.readLock().unlock();
        }
        return persons;
    }

    @Override
    public List<Person> findByAddress(String address) {
        List<Person> persons;
        try {
            lock.readLock().lock();
            persons = findBy(Type.ADDRESS, address);
        } finally {
            lock.readLock().unlock();
        }
        return persons;
    }

    @Override
    public List<Person> findByPhone(String phone) {
        List<Person> persons;
        try {
            lock.readLock().lock();
            persons = findBy(Type.PHONE, phone);
        } finally {
            lock.readLock().unlock();
        }
        return persons;
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
