package ru.mirea.lab11;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class FormDateCalendarObject {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter year, month, day:");
        int year = scanner.nextInt(), month = scanner.nextInt(), day = scanner.nextInt();
        System.out.println("Enter hours, minutes:");
        int hour = scanner.nextInt(), minute = scanner.nextInt();
        scanner.close();
        Calendar calendar = new GregorianCalendar(year, month - 1, day);
        calendar.set(Calendar.HOUR, hour);
        calendar.set(Calendar.MINUTE, minute);
        Date date = calendar.getTime();
        System.out.println("Calendar Object: " + calendar);
        System.out.println("Date Object: " + date);
    }
}
