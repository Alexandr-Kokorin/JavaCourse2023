package edu.hw3.task5;

import java.util.Arrays;
import java.util.Objects;

public final class Task5 {

    private Task5() {}

    public static Contact[] parseContacts(String[] names, Direction direction) {
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

    private static void sort(Contact[] contacts, Direction direction) {
        Arrays.sort(contacts, ((o1, o2) -> {
            if (direction == Direction.ASK) {
                return o1.compareTo(o2);
            } else {
                return o2.compareTo(o1);
            }
        }));
    }
}
