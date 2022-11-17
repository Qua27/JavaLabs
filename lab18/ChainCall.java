package ru.mirea.lab18;

import java.util.Scanner;

public class ChainCall {
    public static void main(String[] args) {
        ThrowsDemo2 throwsDemo = new ThrowsDemo2();
        throwsDemo.getKey();
    }
}

class ThrowsDemo2 {
    public void getKey() {
        Scanner scanner = new Scanner(System.in);
        String key = scanner.next();
        scanner.close();
        while (true) {
            try {
                printDetails(key);
                break;
            } catch (Exception e) {
                System.out.println("Exception occurred");
            }
        }
    }

    public void printDetails(String key) throws Exception {
        try {
            String message = getDetails(key);
            System.out.println(message);
        } catch (Exception e) {
            throw e;
        }
    }

    public String getDetails(String key) throws Exception {
        if (key.equals("")) {
            throw new Exception("Key is empty");
        }
        return "data for " + key;
    }
}
