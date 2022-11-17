package ru.mirea.lab19;

import java.util.Arrays;
import java.util.Collections;

record Student(String firstName, String lastName, double GPA) implements Comparable<Student> {

    @Override
    public int compareTo(Student o) {
        return Double.compare(this.GPA, o.GPA);
    }
}

public class SortingStudentsByGPA {
    private final Student[] students;

    public SortingStudentsByGPA(int size) {
        students = new Student[size];
    }

    public void setStudents(Student... args) throws EmptyStringException {
        int i = 0;
        for (Student student : args) {
            if (student.firstName().equals("") || student.lastName().equals("")) {
                throw new EmptyStringException("Empty first/last name");
            }
            students[i] = student;
            i++;
        }
    }

    public Student searchStudent(String firstName, String lastName) throws StudentNotFoundException {
        for (Student student : students) {
            if (student.firstName().equals(firstName) && student.lastName().equals(lastName)) {
                return student;
            }
        }
        throw new StudentNotFoundException("No such student found");
    }

    public void sort() {
        Arrays.sort(students, Collections.reverseOrder());
    }

    public void outArray() {
        System.out.println(Arrays.toString(students));
    }
}
