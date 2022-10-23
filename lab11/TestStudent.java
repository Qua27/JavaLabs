package ru.mirea.lab11;

import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;

public class TestStudent {
    public static void main(String[] args) {
        Date date = new GregorianCalendar(2003, Calendar.OCTOBER, 6).getTime();
        Student student = new Student("Andrew", date);
        System.out.println(student);
        System.out.println(student.getBirthDateFormatted("yyyy.MM.dd"));
    }
}

class Student {
    private final String name;
    private final Date dateOfBirth;
    private final SimpleDateFormat defaultDateFormat = new SimpleDateFormat("dd.MM.yyyy");

    public Student(String name, Date dateOfBirth) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

    public String getBirthDateFormatted(String format) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        return simpleDateFormat.format(dateOfBirth);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", dateOfBirth: " + defaultDateFormat.format(dateOfBirth) +
                '}';
    }
}
