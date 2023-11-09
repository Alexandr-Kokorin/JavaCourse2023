package edu.hw3.task5;

import org.jetbrains.annotations.NotNull;

public class Contact implements Comparable<Contact> {

    private final String name;
    private final String surname;

    public Contact(String name) {
        String[] temp = name.split(" ");
        if (temp.length == 2) {
            this.name = temp[0];
            this.surname = temp[1];
        } else {
            this.name = name;
            this.surname = null;
        }
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public String toString() {
        return surname != null ? name + " " + surname : name;
    }

    @Override
    public int compareTo(@NotNull Contact o) {
        String name1 = getSurname() != null ? getSurname() : getName();
        String name2 = o.getSurname() != null ? o.getSurname() : o.getName();
        return name1.compareTo(name2);
    }
}
