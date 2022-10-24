package ru.mirea.lab4_1;

public class TestPerson {
    public static void main(String[] args) {
        Person person1 = new Person();
        person1.setFullName("Kyle");
        person1.setAge(18);
        Person person2 = new Person("Jack", 19);
        person1.move();
        person2.talk();
    }
}

class Person {
    private String fullName;
    private int age;

    public Person() {
    }

    public Person(String fullName, int age) {
        this.fullName = fullName;
        this.age = age;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void move() {
        System.out.printf("%s двигается\n", fullName);
    }

    public void talk() {
        System.out.printf("%s говрит\n", fullName);
    }
}
