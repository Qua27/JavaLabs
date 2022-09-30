package ru.mirea.lab2;

import java.util.ArrayList;
import java.util.Arrays;

public class TestDog {
    private static final ArrayList<Dog> dogs = new ArrayList<>();

    private static void addDogs(Dog... severalDogs) {
        dogs.addAll(Arrays.asList(severalDogs));
    }

    public static void main(String[] args) {
        Dog dog1 = new Dog("Max", 4);
        Dog dog2 = new Dog("Rex", 2);
        addDogs(dog1, dog2);
        for (Dog dog : dogs) {
            System.out.println(dog);
        }
    }
}

class Dog {
    private String name;
    private int age;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int AgeToHumanAge() {
        return age * 7;
    }

    @Override
    public String toString() {
        return name + ", " + age + " years = " + AgeToHumanAge() + " in human years";
    }
}
