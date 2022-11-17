package ru.mirea.lab19;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestINN {
    private static void checker(String num) throws IncorrectNumberGivenException {
        Pattern pattern = Pattern.compile("^\\d{12}$");
        Matcher matcher = pattern.matcher(num);
        if (!matcher.matches()) {
            throw new IncorrectNumberGivenException("Exception: There should be 12 numbers");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number:");
        String innNumber = scanner.nextLine();
        scanner.close();
        try {
            checker(innNumber);
            System.out.println("Correct");
        } catch (IncorrectNumberGivenException e) {
            System.out.println(e.getMessage());
        }

    }
}

class IncorrectNumberGivenException extends Exception {
    public IncorrectNumberGivenException(String message) {
        super(message);
    }
}
