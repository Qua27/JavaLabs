package ru.mirea.lab3;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class CurrencyConverter {
    static final double USD_MULTIPLIER = 60.5;

    public static double convertToRUB(double a) {
        return a * USD_MULTIPLIER;
    }

    public static double convertToUSD(double a) {
        return a / USD_MULTIPLIER;
    }

    public static void main(String[] args) {
        NumberFormat numberFormatUSD = NumberFormat.getCurrencyInstance(Locale.US);
        final String RUB_SYMBOL = "\u20BD";
        System.out.println("Choose mode:\n1. USD -> RUB\n2. RUB -> USD");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        double a, b;
        switch (choice) {
            case 1 -> {
                System.out.println("Enter the amount in USD:");
                a = scanner.nextDouble();
                b = convertToRUB(a);
                System.out.println(numberFormatUSD.format(a) + " = " + b + RUB_SYMBOL);
            }
            case 2 -> {
                System.out.println("Enter the amount in RUB:");
                a = scanner.nextDouble();
                b = convertToUSD(a);
                System.out.println(a + RUB_SYMBOL + " = " + numberFormatUSD.format(b));
            }
            default -> {
                System.out.println("Incorrect input");
                scanner.close();
                System.exit(1);
            }
        }
        scanner.close();
    }
}
