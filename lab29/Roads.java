package ru.mirea.lab29;

import java.util.Scanner;

public class Roads {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int sum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sum += scanner.nextInt();
            }
        }
        scanner.close();
        System.out.println(sum / 2);
    }
}
