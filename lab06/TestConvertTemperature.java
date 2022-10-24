package ru.mirea.lab6;

import java.util.ArrayList;
import java.util.Scanner;

interface Convertable {
    ArrayList<Double> convert(double givenValue);
}

public class TestConvertTemperature {
    public static void main(String[] args) {
        System.out.println("Enter the temperature in degrees Celsius:");
        Scanner scanner = new Scanner(System.in);
        double celsius = scanner.nextInt();
        scanner.close();
        ConvertTemperature converter = new ConvertTemperature();
        System.out.printf("%.2f degrees Celsius is %.2f degrees Fahrenheit and %.2f Kelvins\n", celsius, converter.convert(celsius).get(0), converter.convert(celsius).get(1));
    }
}

class ConvertTemperature implements Convertable {

    @Override
    public ArrayList<Double> convert(double celsius) {
        ArrayList<Double> values = new ArrayList<>();
        Double fahrenheit = 1.8 * celsius + 32;
        Double kelvin = celsius + 273.15;
        values.add(fahrenheit);
        values.add(kelvin);
        return values;
    }
}
