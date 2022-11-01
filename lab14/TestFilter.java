package ru.mirea.lab14;

public class TestFilter {
    private static void filter(Object[] objects) {
        Filter filter = new Cleaner();
        for (int i = 0; i < objects.length; i++) {
            if (i % 2 == 1) {
                filter.apply(objects[i]);
            }
        }
    }

    public static void main(String[] args) {
        String[] strings = {"Hello", "world", "it", "is", "me"};
        Integer[] integers = {0, 1, 2, 3, 4, 5};
        filter(strings);
        filter(integers);
    }
}

interface Filter {
    void apply(Object o);
}

class Cleaner implements Filter {
    @Override
    public void apply(Object o) {
        System.out.println(o.toString() + " is considered odd");
    }
}
