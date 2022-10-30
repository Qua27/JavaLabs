package ru.mirea.lab13;

public class TestPerson {
    public static void main(String[] args) {
        Person person1 = new Person("Jefferson");
        Person person2 = new Person("Dan", "Carlson", "JR");
        person1.printName();
        person2.printName();
    }
}

class Person {
    private final String firstName;
    private final String lastName;
    private final String patronymic;

    public Person(String lastName) {
        this.firstName = "";
        this.lastName = lastName;
        this.patronymic = "";
    }

    public Person(String firstName, String lastName, String patronymic) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
    }

    public String getFullName() {
        StringBuilder stringBuilder = new StringBuilder();
        if (!firstName.equals("")) {
            stringBuilder.append(firstName).append(" ");
        }
        stringBuilder.append(lastName);
        if (!patronymic.equals("")) {
            stringBuilder.append(" ").append(patronymic);
        }
        return stringBuilder.toString();
    }

    public void printName() {
        System.out.println(getFullName());
    }
}
