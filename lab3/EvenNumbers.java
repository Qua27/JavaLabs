package ru.mirea.lab3;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class EvenNumbers {
    public static int[] getEvenOnly(int[] numbers, int size) {
        int evenSize = 0;
        for (int i = 0; i < size; i++) {
            if (numbers[i] % 2 == 0) {
                evenSize++;
            }
        }
        int[] even = new int[evenSize];
        int currentNumber;
        int j = 0;
        for (int i = 0; i < size; i++) {
            currentNumber = numbers[i];
            if (currentNumber % 2 == 0) {
                even[j] = currentNumber;
                j++;
            }
        }
        return even;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a natural number:");
        int n = scanner.nextInt();
        while (n <= 0) {
            System.out.println("Try again");
            n = scanner.nextInt();
        }
        scanner.close();
        int[] numbers = new int[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            numbers[i] = random.nextInt(0, n + 1);
        }
        System.out.println(Arrays.toString(numbers));
        int[] evenNumbers = getEvenOnly(numbers, n);
        if (evenNumbers.length != 0) {
            System.out.println(Arrays.toString(evenNumbers));
        }
    }
}
