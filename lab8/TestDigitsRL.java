package ru.mirea.lab8;

import java.util.Scanner;

public class TestDigitsRL {
    private static int getDigits(int n) {
        if (n == 0) {
            return 0;
        }
        System.out.printf("%d ", n % 10);
        return getDigits(n / 10);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter N:");
        int n = scanner.nextInt();
        scanner.close();
        getDigits(n);
    }
}
