package ru.mirea.lab9;

import java.util.Arrays;

public class TestInsertionSort {
    private static void insertionSort(Student[] array) {
        int n = array.length;
        for (int i = 1; i < n; i++) {
            Student key = array[i];
            int j = i - 1;
            while ((j > -1) && (array[j].getIDNumber() > key.getIDNumber())) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        int size = 3;
        Student[] students = new Student[size];
        students[0] = new Student("Andrew", 4);
        students[1] = new Student("Paul", 6);
        students[2] = new Student("Ryan", 2);
        System.out.println(Arrays.toString(students));
        insertionSort(students);
        System.out.println(Arrays.toString(students));
    }
}

class Student {
    private final String name;
    private final int iDNumber;

    public Student(String name, int iDNumber) {
        this.name = name;
        this.iDNumber = iDNumber;
    }

    public String getName() {
        return name;
    }

    public int getIDNumber() {
        return iDNumber;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", iDNumber=" + iDNumber +
                '}';
    }
}
