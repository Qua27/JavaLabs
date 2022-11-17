package ru.mirea.lab19;

import java.util.Scanner;

public class SearchStudent {
    public static void main(String[] args) {
        SortingStudentsByGPA sortingStudentsByGPA = new SortingStudentsByGPA(3);
        Student student1 = new Student("Andrew", "Raff", 50);
        Student student2 = new Student("Mike", "Hoff", 90);
        Student student3 = new Student("Pete", "Jefferson", 80);
        try {
            sortingStudentsByGPA.setStudents(student1, student2, student3);
        } catch (EmptyStringException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Given array:");
        sortingStudentsByGPA.outArray();
        sortingStudentsByGPA.sort();
        System.out.println("Sorted array:");
        sortingStudentsByGPA.outArray();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Searching for (enter first and last name on one line):");
        String input = scanner.nextLine();
        scanner.close();
        String[] name = input.split("\\s+");
        try {
            Student foundStudent = sortingStudentsByGPA.searchStudent(name[0], name[1]);
            System.out.println(foundStudent);
        } catch (StudentNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}

class EmptyStringException extends Exception {
    public EmptyStringException(String message) {
        super(message);
    }
}

class StudentNotFoundException extends Exception {
    public StudentNotFoundException(String message) {
        super(message);
    }
}
