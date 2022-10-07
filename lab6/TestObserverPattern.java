package ru.mirea.lab6;

import java.util.ArrayList;

public class TestObserverPattern {
    public static void main(String[] args) {
        MyStringBuilderObservable myStringBuilderObservable = new MyStringBuilderObservable();
        Observer currentStringDisplay = new CurrentStringDisplay();
        myStringBuilderObservable.registerObserver(currentStringDisplay);
        myStringBuilderObservable.append("Example");
        myStringBuilderObservable.delete(0, 7);
        myStringBuilderObservable.append("Hello");
        myStringBuilderObservable.append("World");
        myStringBuilderObservable.deleteCharAt(4);
        myStringBuilderObservable.deleteCharAt(7);
        myStringBuilderObservable.reverse();
    }
}

interface Observer {
    void update(StringBuilder stringBuilder);
}

interface Observable {
    void registerObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObservers();
}

class MyStringBuilderObservable implements Observable {
    private final ArrayList<Observer> observers;
    private final StringBuilder stringBuilder;

    public MyStringBuilderObservable() {
        observers = new ArrayList<>();
        stringBuilder = new StringBuilder();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(stringBuilder);
        }
    }

    public void append(Object obj) {
        stringBuilder.append(obj);
        notifyObservers();
    }

    public void delete(int start, int end) {
        stringBuilder.delete(start, end);
        notifyObservers();
    }

    public void deleteCharAt(int index) {
        stringBuilder.deleteCharAt(index);
        notifyObservers();
    }

    public void replace(int start, int end, String str) {
        stringBuilder.replace(start, end, str);
        notifyObservers();
    }

    public void insert(int offset, Object obj) {
        stringBuilder.insert(offset, obj);
        notifyObservers();
    }

    public void reverse() {
        stringBuilder.reverse();
        notifyObservers();
    }
}

class CurrentStringDisplay implements Observer {
    private StringBuilder stringBuilder;

    public void display() {
        System.out.println("Current string: " + stringBuilder);
    }

    @Override
    public void update(StringBuilder stringBuilder) {
        this.stringBuilder = stringBuilder;
        display();
    }
}
