package ru.mirea.lab26;

import java.util.Arrays;
import java.util.Stack;

public class Invert {
    public static void main(String[] args) {
        int size = 6;
        Object[] objects = {1, 2, 3, 4, 5, 6};
        Stack<Object> stack = new Stack<>();
        for (Object o : objects) {
            stack.push(o);
        }
        int numberOfIterations = size / 2;
        for (int i = 0; i < numberOfIterations; i++) {
            Object tmp = objects[i];
            objects[i] = stack.pop();
            objects[size - 1 - i] = tmp;
        }
        System.out.println(Arrays.toString(objects));
    }
}
