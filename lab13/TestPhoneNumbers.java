package ru.mirea.lab13;

import java.util.Scanner;

public class TestPhoneNumbers {
    public static void main(String[] args) {
        System.out.println("Enter a phone number");
        Scanner scanner = new Scanner(System.in);
        String phoneNumberGotRaw = scanner.nextLine();
        scanner.close();
        String phoneNumberGot;
        if (phoneNumberGotRaw.charAt(0) == '8') {
            if (phoneNumberGotRaw.length() != 11) {
                System.out.println("Incorrect Input");
                System.exit(1);
            }
            phoneNumberGot = phoneNumberGotRaw.replaceFirst("8", "\\+7");
        } else {
            phoneNumberGot = phoneNumberGotRaw;
        }
        int sizeOfCountryCode = phoneNumberGot.length() - 11;
        String regex = "(\\+\\d{" + sizeOfCountryCode + "})(\\d{3})(\\d{3})(\\d{4})";
        String phoneNumberFormatted = phoneNumberGot.replaceFirst(regex, "$1 $2-$3-$4");
        System.out.println(phoneNumberFormatted);
    }
}
