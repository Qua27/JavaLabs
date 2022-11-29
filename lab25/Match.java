package ru.mirea.lab25;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Match {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("abcdefghijklmnopqrstuv18340");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string:");
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
