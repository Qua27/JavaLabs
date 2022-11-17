package ru.mirea.lab18;

public class DivisionByZero {
    public static void main(String[] args) {
        try {
            System.out.println(2 / 0);
        } catch (ArithmeticException e) {
            System.out.println("Division by zero");
        }
    }
}
