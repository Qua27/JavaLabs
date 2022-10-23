package ru.mirea.lab11;

import java.util.ArrayList;
import java.util.LinkedList;

public class TimeComparison {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();
        long startTime;
        System.out.println("--- ArrayList and LinkedList methods time comparison ---");

        System.out.println("Add:");
        startTime = System.nanoTime();
        arrayList.add(1);
        printTimePassed(startTime);
        System.out.print("    ");

        startTime = System.nanoTime();
        linkedList.add(1);
        printTimePassed(startTime);
        System.out.println();

        System.out.println("Remove:");
        startTime = System.nanoTime();
        arrayList.remove((Integer) 1);
        printTimePassed(startTime);
        System.out.print("    ");

        startTime = System.nanoTime();
        linkedList.remove((Integer) 1);
        printTimePassed(startTime);
        System.out.println();

        arrayList.add(1);
        linkedList.add(1);

        System.out.println("IndexOf:");
        startTime = System.nanoTime();
        arrayList.indexOf(1);
        printTimePassed(startTime);
        System.out.print("    ");

        startTime = System.nanoTime();
        linkedList.indexOf(1);
        printTimePassed(startTime);
    }

    private static void printTimePassed(long startTime) {
        long estimatedTime = System.nanoTime() - startTime;
        System.out.printf("%f ms", (double) estimatedTime / 1000000);
    }
}
