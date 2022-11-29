package ru.mirea.lab25;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PriceExtractor {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("path/file.txt");
        Scanner scanner = new Scanner(file);
        String str = scanner.nextLine();
        scanner.close();
        Pattern patternUSD = Pattern.compile("\\d+\\.\\d{1,2}\\s+USD");
        Pattern patternRUB = Pattern.compile("\\d+\\.\\d{1,2}\\s+RUB");
        Pattern patternEUR = Pattern.compile("\\d+\\.\\d{1,2}\\s+EUR");
        Matcher matcherUSD = patternUSD.matcher(str);
        Matcher matcherRUB = patternRUB.matcher(str);
        Matcher matcherEUR = patternEUR.matcher(str);
        System.out.println("Prices in dollars:");
        while (matcherUSD.find()) {
            System.out.println(str.substring(matcherUSD.start(), matcherUSD.end()));
        }
        System.out.println();
        System.out.println("Prices in rubles:");
        while (matcherRUB.find()){
            System.out.println(str.substring(matcherRUB.start(), matcherRUB.end()));
        }
        System.out.println();
        System.out.println("Prices in euros:");
        while (matcherEUR.find()){
            System.out.println(str.substring(matcherEUR.start(), matcherEUR.end()));
        }
     }
}
