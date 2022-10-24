package ru.mirea.lab6;

interface Nameable {
    String getName();
}

public class TestName {
    public static void main(String[] args) {
        Nameable planet = new Planet("Earth");
        Nameable car = new Car("Audi");
        Nameable animal = new Animal("Fox");
        System.out.println(planet.getName());
        System.out.println(car.getName());
        System.out.println(animal.getName());
    }
}

class Planet implements Nameable {
    private String name;

    public Planet(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}

class Car implements Nameable {
    private String model;

    public Car(String model) {
        this.model = model;
    }

    @Override
    public String getName() {
        return model;
    }
}

class Animal implements Nameable {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
