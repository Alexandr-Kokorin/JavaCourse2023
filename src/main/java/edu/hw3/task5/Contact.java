package edu.hw3.task5;

public class Contact {

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
}
