package ru.mirea.lab11;

import java.util.Scanner;
import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class CompareDates {
    @Deprecated
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Comparing current date with date you enter");
        System.out.println("Enter the day, month and year:");
        int day = scanner.nextInt(), month = scanner.nextInt(), year = scanner.nextInt();
        scanner.close();
        Calendar calendar = new GregorianCalendar(year, month - 1, day);
        Date date = calendar.getTime();
        Date now = new Date();
        if (now.getYear() + 1900 == year && now.getMonth() + 1 == month && now.getDate() == day) {
            System.out.println("The dates are the same");
        } else if (date.before(now)) {
            System.out.println("The entered date is before current date");
        } else if (date.after(now)) {
            System.out.println("The entered date is after current date");
        }
    }
}
