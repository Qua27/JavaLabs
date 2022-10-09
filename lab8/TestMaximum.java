package ru.mirea.lab8;

import java.util.Scanner;

public class TestMaximum {
    public static int getMaximum() {
        Scanner scanner = new Scanner(System.in);
        int integer = scanner.nextInt();
        if (integer == 0) {
            return 0;
        }
        return Math.max(integer, getMaximum());
    }

    public static void main(String[] args) {
        System.out.println("Enter the sequence of numbers (enter 0 in the end):");
        System.out.println(getMaximum());
    }
}
