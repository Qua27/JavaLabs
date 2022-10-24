package ru.mirea.lab9;

import java.util.Arrays;

public class TestMergeSort {
    private static void merge(Student[] a, Student[] l, Student[] r, int left, int right) {
        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l[i].getIDNumber() <= r[j].getIDNumber()) {
                a[k++] = l[i++];
            } else {
                a[k++] = r[j++];
            }
        }
        while (i < left) {
            a[k++] = l[i++];
        }
        while (j < right) {
            a[k++] = r[j++];
        }
    }

    private static void mergeSort(Student[] a) {
        mergeSort(a, a.length);
    }

    private static void mergeSort(Student[] a, int n) {
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        Student[] l = new Student[mid];
        Student[] r = new Student[n - mid];
        System.arraycopy(a, 0, l, 0, mid);
        if (n - mid >= 0) {
            System.arraycopy(a, mid, r, 0, n - mid);
        }
        mergeSort(l, mid);
        mergeSort(r, n - mid);
        merge(a, l, r, mid, n - mid);
    }


    public static void main(String[] args) {
        int size1 = 3;
        int size2 = 2;
        Student[] students1 = new Student[size1];
        Student[] students2 = new Student[size2];
        students1[0] = new Student("Andrew", 4);
        students1[1] = new Student("Paul", 6);
        students1[2] = new Student("Ryan", 2);
        students2[0] = new Student("Bob", 6);
        students2[1] = new Student("Ted", 5);
        Student[] students = new Student[size1 + size2];
        System.arraycopy(students1, 0, students, 0, size1);
        System.arraycopy(students2, 0, students, size1, size2);
        mergeSort(students);
        System.out.println(Arrays.toString(students));
    }
}
