package ru.mirea.lab3;

import java.util.Arrays;
import java.util.Random;

public class TestArrays {
    public static void main(String[] args) {
        double[] array = new double[5];
        Random random = new Random();
        for (int i = 0; i < 3; i++) {
            array[i] = random.nextDouble();
        }
        for (int i = 3; i < 5; i++) {
            array[i] = Math.random();
        }
        System.out.println(Arrays.toString(array));
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
    }
}
