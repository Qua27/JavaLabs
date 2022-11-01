package ru.mirea.lab14;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailCheck {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("^[a-z]+?@[a-z]+\\.?[a-z]+$");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the string:");
        String string = scanner.nextLine();
        scanner.close();
        Matcher matcher = pattern.matcher(string);
        if (matcher.matches()) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
