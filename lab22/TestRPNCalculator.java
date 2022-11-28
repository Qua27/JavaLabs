package ru.mirea.lab22;

import java.util.EmptyStackException;
import java.util.Scanner;
import java.util.Stack;

public class TestRPNCalculator {
    private static boolean isNumber(String s) {
        return s.matches("^-?\\d+\\.?\\d+$") || s.matches("^-?\\d$");
    }

    private static boolean isOperationSign(String s) {
        if (s.length() != 1) {
            return false;
        }
        char c = s.charAt(0);
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    private static double evaluate(double a, double b, String op) throws IncorrectOperationException, ArithmeticException {
        switch (op) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                if (b == 0) {
                    throw new ArithmeticException("Division by zero");
                }
                return a / b;
            default:
                throw new IncorrectOperationException();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        scanner.close();
        String[] parsed = input.split("\\s+");
        Stack<Double> stack = new Stack<>();
        try {
            for (String current : parsed) {
                if (isNumber(current)) {
                    stack.push(Double.parseDouble(current));
                } else if (isOperationSign(current)) {
                    double b = stack.pop();
                    double a = stack.pop();
                    double res = evaluate(a, b, current);
                    stack.push(res);
                } else {
                    throw new IncorrectOperationException();
                }
            }
            double result = stack.pop();
            if (!stack.isEmpty()) {
                System.out.println("Not enough operations");
            } else {
                System.out.println(result);
            }
        } catch (IncorrectOperationException | ArithmeticException e) {
            System.out.println(e.getMessage());
            System.exit(0);
        } catch (EmptyStackException e) {
            System.out.println("Unable to pop from stack");
            System.exit(0);
        }
    }
}
