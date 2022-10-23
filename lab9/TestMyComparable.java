package ru.mirea.lab9;

interface MyComparable<T> {
    int compareTo(T o);
}

public class TestMyComparable {
    public static void main(String[] args) {
        MyClass myClass1 = new MyClass(1, 1.2);
        MyClass myClass2 = new MyClass(2, 1.5);
        System.out.println(myClass1.compareTo(myClass2));
    }
}

class MyClass implements MyComparable<MyClass> {
    private final int field1;
    private final double field2;

    public MyClass(int field1, double field2) {
        this.field1 = field1;
        this.field2 = field2;
    }

    @Override
    public int compareTo(MyClass o) {
        return Double.compare(field2, o.field2);
    }
}
