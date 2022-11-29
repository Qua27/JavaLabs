package ru.mirea.lab25;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Plus {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("\\d\\+");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the expression:");
        String expr = scanner.nextLine();
        scanner.close();
        Matcher matcher = pattern.matcher(expr);
        if (matcher.find()) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
