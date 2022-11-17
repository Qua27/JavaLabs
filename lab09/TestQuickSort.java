package ru.mirea.lab9;

import java.util.Arrays;
import java.util.Comparator;

public class TestQuickSort {
    public static void main(String[] args) {
        int size = 3;
        Student_[] students = new Student_[size];
        students[0] = new Student_("Andrew", 50);
        students[1] = new Student_("Paul", 90);
        students[2] = new Student_("Ryan", 80);
        System.out.println(Arrays.toString(students));
        SortingStudentsByGPA sortingStudentsByGPA = new SortingStudentsByGPA();
        sortingStudentsByGPA.quickSort(students);
        System.out.println(Arrays.toString(students));
    }
}

record Student_(String name, int gpa) {
}

class SortingStudentsByGPA implements Comparator<Student_> {
    public void swap(Student_[] array, int i, int j) {
        Student_ temporary = array[i];
        array[i] = array[j];
        array[j] = temporary;
    }

    public int partition(Student_[] array, int begin, int end) {
        int i = begin - 1;
        for (int j = begin; j < end; j++) {
            if (this.compare(array[j], array[end]) > 0) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, end);
        return i + 1;
    }

    public void quickSort(Student_[] array) {
        quickSort(array, 0, array.length - 1);
    }

    public void quickSort(Student_[] array, int begin, int end) {
        if (begin < end) {
            int pivotIndex = partition(array, begin, end);
            quickSort(array, begin, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, end);
        }
    }

    @Override
    public int compare(Student_ o1, Student_ o2) {
        return Double.compare(o1.gpa(), o2.gpa());
    }
}
