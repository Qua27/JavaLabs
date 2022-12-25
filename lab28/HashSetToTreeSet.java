package ru.mirea.lab28;

import java.util.HashSet;
import java.util.TreeSet;

public class HashSetToTreeSet {
    public static void main(String[] args) {
        HashSet<Object> hashSet = new HashSet<>();
        hashSet.add(3);
        hashSet.add(2);
        hashSet.add(1);
        TreeSet<Object> treeSet = new TreeSet<>(hashSet);
        System.out.println(treeSet);
    }
}
