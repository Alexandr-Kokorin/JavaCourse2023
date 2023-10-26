package edu.hw3.task5;

import java.util.Arrays;
import java.util.Objects;

public final class Task5 {

    private Task5() {}

    public static Contact[] parseContacts(String[] names, String direction) {
        if (Objects.isNull(names)) {
            return new Contact[0];
        }
        Contact[] contacts = new Contact[names.length];
        for (int i = 0; i < names.length; i++) {
            contacts[i] = new Contact(names[i]);
        }
        sort(contacts, direction);
        return contacts;
    }

    private static void sort(Contact[] contacts, String direction) {
        Arrays.sort(contacts, ((o1, o2) -> {
            String name1 = o1.getSurname() != null ? o1.getSurname() : o1.getName();
            String name2 = o2.getSurname() != null ? o2.getSurname() : o2.getName();
            if (direction.equals("ASC")) {
                return name1.compareToIgnoreCase(name2);
            } else {
                return name2.compareToIgnoreCase(name1);
            }
        }));
    }
}
