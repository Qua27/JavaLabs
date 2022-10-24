package ru.mirea.lab8;

import java.util.Scanner;

public class TestDigitsLR {
    private static int getLength(int n) {
        return getLength(n, 0);
    }

    private static int getLength(int n, int i) {
        if (n / (int) Math.pow(10, i) == 0) {
            return i;
        }
        return getLength(n, ++i);
    }

    private static int getDigits(int n, int i) {
        if (i == 0) {
            return 0;
        }
        System.out.printf("%d ", ((int) (n / Math.pow(10, i - 1))) % 10);
        return getDigits(n, i - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter N:");
        int n = scanner.nextInt();
        scanner.close();
        getDigits(n, getLength(n));
    }
}
