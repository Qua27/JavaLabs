package ru.mirea.lab26;

import java.util.Iterator;

// Iterator overridden inside MyList class that implements Iterable interface

public class MyList<E> implements Iterable<E> {
    private final E[] arrayList;
    private final int currentSize;

    public MyList(E[] newArray) {
        this.arrayList = newArray;
        this.currentSize = arrayList.length;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < currentSize && arrayList[currentIndex] != null;
            }

            @Override
            public E next() {
                return arrayList[currentIndex++];
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
}
