package ru.mirea.lab4_1;

public class TestLearners {
    public static void main(String[] args) {
        Learner schoolchild1 = new Schoolchild("Paul", 12, 7);
        Learner student1 = new Student("Ray", 21, 4);
        Learner schoolchild2 = new Schoolchild("Robert", 15, 9);
        Learner student2 = new Student("Hans", 19, 2);
        Learner[] learners = {schoolchild1, student1, schoolchild2, student2};
        System.out.println("Schoolchildren:");
        for (Learner learner : learners) {
            if (learner.getClass().getName().equals("ru.mirea.lab4_1.Schoolchild")) {
                System.out.println(learner);
            }
        }
        System.out.println("\nStudents:");
        for (Learner learner : learners) {
            if (learner.getClass().getName().equals("ru.mirea.lab4_1.Student")) {
                System.out.println(learner);
            }
        }
    }
}

class Learner {
    private String name;
    private int age;

    public Learner(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Learner{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

class Schoolchild extends Learner {
    private int schoolClass;

    public Schoolchild(String name, int age, int schoolClass) {
        super(name, age);
        this.schoolClass = schoolClass;
    }
}

class Student extends Learner {
    private int universityCourse;

    public Student(String name, int age, int universityCourse) {
        super(name, age);
        this.universityCourse = universityCourse;
    }
}
