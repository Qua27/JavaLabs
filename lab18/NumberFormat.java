package ru.mirea.lab18;

import java.util.Scanner;

public class NumberFormat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter an integer:");
        String intString = scanner.next();
        scanner.close();
        try {
            int i = Integer.parseInt(intString);
            System.out.println(2 / i);
        } catch (Exception e) {
            System.out.println("Incorrect input format");
        } finally {
            System.out.println("Program finished");
        }
    }
}
