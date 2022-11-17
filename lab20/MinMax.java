package ru.mirea.lab20;

public class MinMax<E extends Comparable<E>> {
    private final E[] array;

    public MinMax(E[] array) {
        this.array = array;
    }

    public E getMin() {
        E min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i].compareTo(min) < 0) {
                min = array[i];
            }
        }
        return min;
    }

    public E getMax() {
        E max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i].compareTo(max) > 0) {
                max = array[i];
            }
        }
        return max;
    }
}
