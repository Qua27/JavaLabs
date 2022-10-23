package ru.mirea.lab11;

import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;

public class TestDeveloper {
    public static void main(String[] args) {
        Calendar calendarTaskGot = new GregorianCalendar(2022, Calendar.SEPTEMBER, 5);
        calendarTaskGot.set(Calendar.HOUR, 10);
        calendarTaskGot.set(Calendar.MINUTE, 0);
        calendarTaskGot.set(Calendar.SECOND, 0);
        Date dateTaskPassed = new Date();
        Developer developer = new Developer("Bob");
        Date dateTaskGot = calendarTaskGot.getTime();
        developer.setDateTaskGot(dateTaskGot);
        developer.setDateTaskPassed(dateTaskPassed);
        System.out.println(developer);
    }
}

class Developer {
    private final String name;
    private Date dateTaskGot;
    private Date dateTaskPassed;
    private final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss z");

    public Developer(String name) {
        this.name = name;
    }

    public Developer(String name, Date dateTaskGot, Date dateTaskPassed) {
        this.name = name;
        this.dateTaskGot = dateTaskGot;
        this.dateTaskPassed = dateTaskPassed;
    }

    public String getName() {
        return name;
    }

    public Date getDateTaskGot() {
        return dateTaskGot;
    }

    public void setDateTaskGot(Date dateTaskGot) {
        this.dateTaskGot = dateTaskGot;
    }

    public Date getDateTaskPassed() {
        return dateTaskPassed;
    }

    public void setDateTaskPassed(Date dateTaskPassed) {
        this.dateTaskPassed = dateTaskPassed;
    }

    @Override
    public String toString() {
        return "Developer{" +
                "name='" + name + '\'' +
                ", dateTaskGot: " + simpleDateFormat.format(dateTaskGot.getTime()) +
                ", dateTaskPassed: " + simpleDateFormat.format(dateTaskPassed) +
                '}';
    }
}
