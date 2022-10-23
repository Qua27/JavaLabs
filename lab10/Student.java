package ru.mirea.lab10;

public class Student {
    private String firstName;
    private String lastName;
    private String specialty;
    private int course;
    private String group;
    private double GPA;

    public Student(String firstName, double GPA) {
        this.firstName = firstName;
        this.GPA = GPA;
    }

    public Student(String firstName, String lastName, String specialty, int course, String group, double GPA) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.specialty = specialty;
        this.course = course;
        this.group = group;
        this.GPA = GPA;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public double getGPA() {
        return GPA;
    }

    public void setGPA(double GPA) {
        this.GPA = GPA;
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", GPA=" + GPA +
                '}';
    }

    public String getAllInfo() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", specialty='" + specialty + '\'' +
                ", course=" + course +
                ", group='" + group + '\'' +
                ", GPA=" + GPA +
                '}';
    }
}
