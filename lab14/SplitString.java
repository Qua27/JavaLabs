package ru.mirea.lab14;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SplitString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = "This is an example string";
        String regex = scanner.nextLine();
        scanner.close();
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            System.out.println(text.substring(matcher.start(), matcher.end()));
        }
    }
}
