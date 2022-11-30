package ru.mirea.lab27;

import java.util.Comparator;
import java.util.PriorityQueue;

public class TestHashTab {
    public static void main(String[] args) {
        HashTab hashTab = new HashTab();
        Integer[] keys = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        String[] values = {"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten"};
        hashTab.HashTabInit(keys, values);
        System.out.println(hashTab.HashTabLookUp(7));
        hashTab.HashTabRemove(7);
        System.out.println(hashTab.HashTabLookUp(7));
        System.out.println("---------------------");
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(Integer::intValue));
        priorityQueue.add(10);
        priorityQueue.add(30);
        priorityQueue.add(20);
        priorityQueue.add(15);
        priorityQueue.add(25);
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.poll());
    }
}
