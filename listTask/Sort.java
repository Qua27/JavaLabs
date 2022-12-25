package ru.mirea.listTask;

import java.util.LinkedList;

public class Sort {
    private static void swapValues(LinkedList<Integer> linkedList, int x, int y) {
        int swap;
        swap = linkedList.get(y);
        linkedList.set(y, linkedList.get(x));
        linkedList.set(x, swap);
    }

    private static LinkedList<Integer> innerSort(LinkedList<Integer> linkedList) {
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < linkedList.size() - 1; i++) {
                if (linkedList.get(i) > linkedList.get(i + 1)) {
                    swapValues(linkedList, i, i + 1);
                    isSorted = false;
                }
            }
        }
        return linkedList;
    }

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(8);
        linkedList.add(4);
        linkedList.add(6);
        linkedList.add(5);
        linkedList.add(7);
        System.out.println(linkedList);
        System.out.println(innerSort(linkedList));
    }
}
