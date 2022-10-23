package ru.mirea.lab10;

import java.util.Arrays;

public class TestMerge {
    public static void main(String[] args) {
        int size1 = 3, size2 = 2;
        Student[] array1 = new Student[size1], array2 = new Student[size2];
        initializeArraysOfStudents(array1, array2);
        Student[] result = new Student[size1 + size2];
        System.arraycopy(array1, 0, result, 0, size1);
        System.arraycopy(array2, 0, result, size1, size2);
        System.out.println(Arrays.toString(result));
        (new SortingStudentsByGPA()).mergeSort(result);
        System.out.println(Arrays.toString(result));
    }

    private static void initializeArraysOfStudents(Student[] s1, Student[] s2) {
        Student student1 = new Student("Alex", 90);
        Student student2 = new Student("Andrew", 80);
        Student student3 = new Student("Bob", 85);
        Student student4 = new Student("John", 70);
        Student student5 = new Student("Lee", 95);
        s1[0] = student1;
        s1[1] = student2;
        s1[2] = student3;
        s2[0] = student4;
        s2[1] = student5;
    }
}
