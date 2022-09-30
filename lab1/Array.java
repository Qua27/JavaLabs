package ru.mirea.lab1;

import java.util.Scanner;

public class Array {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the size of the array:");
        int size = scanner.nextInt();
        if (size <= 0) {
            System.out.println("Size must be a positive number");
            System.exit(1);
        }
        int[] array = new int[size];
        int sum = 0;
        System.out.printf("Enter %d numbers:\n", size);
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
            sum += array[i];
        }
        scanner.close();
        double av = (double) sum / size;
        System.out.println(sum);
        System.out.println(av);
    }
}
