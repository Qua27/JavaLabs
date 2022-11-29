package ru.mirea.lab25;

import java.util.Calendar;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateChecker {
    private static int getDaysOfMonth(int month, int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR,year);
        calendar.set(Calendar.MONTH,month);
        return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
    }

    private static boolean extraCheck(String string) {
        String[] dateParsed = string.split("/");
        int day = Integer.parseInt(dateParsed[0]);
        int month = Integer.parseInt(dateParsed[1]) - 1;
        int year = Integer.parseInt(dateParsed[2]);
        return day <= getDaysOfMonth(month, year);
    }

    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("^(0[1-9]|1\\d|2\\d|3[01])/(0[1-9]|1[0-2])/(19|[2-9]\\d)\\d{2}$");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the string:");
        String string = scanner.nextLine();
        scanner.close();
        Matcher matcher = pattern.matcher(string);
        if (matcher.matches() && extraCheck(string)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
