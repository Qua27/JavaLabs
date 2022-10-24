package ru.mirea.lab9;

import java.util.Arrays;
import java.util.Comparator;

public class TestQuickSort {
    public static void main(String[] args) {
        int size = 3;
        Student_[] students = new Student_[size];
        students[0] = new Student_("Andrew", 40);
        students[1] = new Student_("Paul", 60);
        students[2] = new Student_("Ryan", 20);
        System.out.println(Arrays.toString(students));
        SortingStudentsByGPA sortingStudentsByGPA = new SortingStudentsByGPA();
        sortingStudentsByGPA.quickSort(students);
        System.out.println(Arrays.toString(students));
    }
}

record Student_(String name, int gpa) {
}

class SortingStudentsByGPA implements Comparator<Student_> {

    public void quickSort(Student_[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    public void quickSort(Student_[] arr, int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);
            quickSort(arr, begin, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, end);
        }
    }

    private int partition(Student_[] arr, int begin, int end) {
        Student_ pivot = arr[end];
        int i = begin;
        for (int j = end; j >= begin; j--) {
            if (this.compare(arr[j], pivot) > 0) {
                Student_ temp1 = arr[i];
                arr[i] = arr[j];
                arr[j] = temp1;
                i = i + 1;
            }
        }
        Student_ temp2 = arr[i];
        arr[i] = arr[end];
        arr[end] = temp2;
        return i;
    }

    @Override
    public int compare(Student_ o1, Student_ o2) {
        return Double.compare(o1.gpa(), o2.gpa());
    }
}
