package ru.mirea.lab1;

import java.util.Scanner;

public class MaxMin {
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
        int i = 0;
        do {
            array[i] = scanner.nextInt();
            sum += array[i];
            i++;
        } while (i < size);
        scanner.close();
        int min = Integer.MAX_VALUE;
        int max = -min;
        i = 0;
        while (i < size) {
            int num = array[i];
            min = Math.min(min, num);
            max = Math.max(max, num);
            i++;
        }
        System.out.println("Sum is " + sum);
        System.out.println("Min is " + min);
        System.out.println("Max is " + max);
    }
}
