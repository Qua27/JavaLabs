package ru.mirea.lab2;

import java.util.Arrays;

public class Reversing {
    private static void reverseStrings(String[] strings) {
        for (int i = 0; i < strings.length / 2; i++) {
            String tmp = strings[i];
            int partner_index = strings.length - 1 - i;
            strings[i] = strings[partner_index];
            strings[partner_index] = tmp;
        }
    }

    public static void main(String[] args) {
        String[] strings = {"Hello", "my", "name", "is", "Andrew"};
        reverseStrings(strings);
        System.out.println(Arrays.toString(strings));
    }
}
