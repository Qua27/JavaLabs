package ru.mirea.lab28;

import java.util.Hashtable;

public class Table {
    public static void main(String[] args) {
        Hashtable<Double, Object> hashtable = new Hashtable<>();
        hashtable.put(1.02, "Hello");
        hashtable.put(2.51, 3.42);
        hashtable.put(8.43, 5);
        System.out.println(hashtable);
    }
}
