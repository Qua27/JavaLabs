package ru.mirea.lab10;

import java.util.Arrays;
import java.util.Comparator;

public class TestSorting {
    public static void main(String[] args) {
        SortingStudentsByGPA sortingStudentsByGPA = new SortingStudentsByGPA();
        sortingStudentsByGPA.setStudents(new Student("Andrew", 50),
                new Student("Mike", 90), new Student("Alex", 80));
        System.out.println("Given array:");
        sortingStudentsByGPA.outArray();
        sortingStudentsByGPA.quickSort();
        System.out.println("Sorted array:");
        sortingStudentsByGPA.outArray();
    }
}

class GeneralComparator implements Comparator<Student> {
    int size = 3;
    private final Student[] students = new Student[size];

    public void setStudents(Student... args) {
        int i = 0;
        for (Student student : args) {
            students[i] = student;
            i++;
        }
    }

    public void swap(Student[] array, int i, int j) {
        Student temporary = array[i];
        array[i] = array[j];
        array[j] = temporary;
    }

    public int partition(Student[] array, int begin, int end) {
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

    public void quickSort() {
        quickSort(students);
    }

    public void quickSort(Student[] array) {
        quickSort(array, 0, array.length - 1);
    }

    public void quickSort(Student[] array, int begin, int end) {
        if (begin < end) {
            int pivotIndex = partition(array, begin, end);
            quickSort(array, begin, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, end);
        }
    }

    public void mergeSort() {
        mergeSort(students);
    }

    public void mergeSort(Student[] array) {
        mergeSort(array, 0, array.length - 1);
    }

    public void mergeSort(Student[] array, int low, int high) {
        if (high <= low)
            return;
        int mid = (low + high) / 2;
        mergeSort(array, low, mid);
        mergeSort(array, mid + 1, high);
        merge(array, low, mid, high);
    }

    public void merge(Student[] array, int low, int mid, int high) {
        Student[] leftArray = new Student[mid - low + 1];
        Student[] rightArray = new Student[high - mid];
        System.arraycopy(array, low, leftArray, 0, leftArray.length);
        for (int i = 0; i < rightArray.length; i++)
            rightArray[i] = array[mid + i + 1];
        int leftIndex = 0;
        int rightIndex = 0;
        for (int i = low; i < high + 1; i++) {
            if (leftIndex < leftArray.length && rightIndex < rightArray.length) {
                if (this.compare(leftArray[leftIndex], rightArray[rightIndex]) >= 0) {
                    array[i] = leftArray[leftIndex];
                    leftIndex++;
                } else {
                    array[i] = rightArray[rightIndex];
                    rightIndex++;
                }
            } else if (leftIndex < leftArray.length) {
                array[i] = leftArray[leftIndex];
                leftIndex++;
            } else if (rightIndex < rightArray.length) {
                array[i] = rightArray[rightIndex];
                rightIndex++;
            }
        }
    }

    public void outArray() {
        System.out.println(Arrays.toString(students));
    }

    @Override
    public int compare(Student o1, Student o2) {
        return o1.getFirstName().compareTo(o2.getFirstName());
    }
}

class SortingStudentsByGPA extends GeneralComparator {

    @Override
    public int compare(Student o1, Student o2) {
        return Double.compare(o1.getGPA(), o2.getGPA());
    }
}

class SortingStudentsByCourse extends GeneralComparator {

    @Override
    public int compare(Student o1, Student o2) {
        return Integer.compare(o1.getCourse(), o2.getCourse());
    }
}
