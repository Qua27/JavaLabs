package ru.mirea.lab20;

import java.io.Serializable;

public class GeneralClass<T extends Comparable<T>, V extends Animal & Serializable, K> {
    private final T a;
    private final V b;
    private final K c;

    public GeneralClass(T a, V b, K c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public T getA() {
        return a;
    }

    public V getB() {
        return b;
    }

    public K getC() {
        return c;
    }

    public void printClass() {
        System.out.println(a.getClass().getName() + ", " + b.getClass().getName() + ", " + c.getClass().getName());
    }
}

class Animal implements Serializable {
    private final String name;

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                '}';
    }
}
