package ru.mirea.lab3;

import java.util.Arrays;
import java.util.Random;

public class IncreasingSeq {
    public static boolean isRisingSeq(int[] numbers, int size) {
        for (int i = 0; i < size - 1; i++) {
            if (numbers[i + 1] < numbers[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Random random = new Random();
        int size = 4;
        int[] numbers = new int[size];
        for (int i = 0; i < size; i++) {
            numbers[i] = random.nextInt(10, 100);
        }
        System.out.println(Arrays.toString(numbers));
        System.out.println("isIncreasingSequence: " + isRisingSeq(numbers, size));
    }
}
