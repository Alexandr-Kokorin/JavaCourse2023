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
        lock.writeLock().lock();
        database.put(person.id(), person);
        lock.writeLock().unlock();
    }

    @Override
    public void delete(int id) {
        lock.writeLock().lock();
        database.remove(id);
        lock.writeLock().unlock();
    }

    @Override
    public List<Person> findByName(String name) {
        lock.readLock().lock();
        List<Person> persons = new ArrayList<>();
        for (int id : database.keySet()) {
            if (database.get(id).name().equals(name)) {
                persons.add(database.get(id));
            }
        }
        lock.readLock().unlock();
        return persons;
    }

    @Override
    public List<Person> findByAddress(String address) {
        lock.readLock().lock();
        List<Person> persons = new ArrayList<>();
        for (int id : database.keySet()) {
            if (database.get(id).address().equals(address)) {
                persons.add(database.get(id));
            }
        }
        lock.readLock().unlock();
        return persons;
    }

    @Override
    public List<Person> findByPhone(String phone) {
        lock.readLock().lock();
        List<Person> persons = new ArrayList<>();
        for (int id : database.keySet()) {
            if (database.get(id).phoneNumber().equals(phone)) {
                persons.add(database.get(id));
            }
        }
        lock.readLock().unlock();
        return persons;
    }
}
