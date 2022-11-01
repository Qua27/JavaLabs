package ru.mirea.lab14;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class FrequencyDict {
    public static void main(String[] args) throws FileNotFoundException {
        File source = new File("path/file.txt");
        Scanner scanner = new Scanner(source);
        HashMap<Character, Integer> dict = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            dict.put((char) (i + 97), 0);
        }
        while (scanner.hasNext()) {
            String rawLine = scanner.nextLine();
            String line = rawLine.toLowerCase();
            for (int i = 0; i < line.length(); i++) {
                char character = line.charAt(i);
                if (dict.containsKey(character)) {
                    dict.put(character, dict.get(character) + 1);
                }
            }
        }
        scanner.close();
        System.out.println(dict);
    }
}
