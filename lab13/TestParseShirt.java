package ru.mirea.lab13;

import java.util.Arrays;
import java.util.StringTokenizer;

public class TestParseShirt {
    public static void main(String[] args) {
        int size = 11;
        String[] shirts = new String[size];
        initializeArray(shirts);
        System.out.println(Arrays.toString(parseShirtsFromStringArray(shirts, size)));
    }

    private static Shirt[] parseShirtsFromStringArray(String[] strings, int size) {
        Shirt[] shirts = new Shirt[size];
        for (int i = 0; i < size; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(strings[i], ",");
            Shirt shirt = new Shirt(stringTokenizer.nextToken(), stringTokenizer.nextToken(), stringTokenizer.nextToken(), stringTokenizer.nextToken());
            shirts[i] = shirt;
        }
        return shirts;
    }

    private static void initializeArray(String[] shirts) {
        shirts[0] = "S001,Black Polo Shirt,Black,XL";
        shirts[1] = "S002,Black Polo Shirt,Black,L";
        shirts[2] = "S003,Blue Polo Shirt,Blue,XL";
        shirts[3] = "S004,Blue Polo Shirt,Blue,M";
        shirts[4] = "S005,Tan Polo Shirt,Tan,XL";
        shirts[5] = "S006,Black T-Shirt,Black,XL";
        shirts[6] = "S007,White TShirt,White,XL";
        shirts[7] = "S008,White T-Shirt,White,L";
        shirts[8] = "S009,Green T-Shirt,Green,S";
        shirts[9] = "S010,Orange T-Shirt,Orange,S";
        shirts[10] = "S011,Maroon Polo Shirt,Maroon,S";
    }
}

class Shirt {
    private final String model;
    private final String name;
    private final String color;
    private final String size;

    public Shirt(String model, String name, String color, String size) {
        this.model = model;
        this.name = name;
        this.color = color;
        this.size = size;
    }

    @Override
    public String toString() {
        return "Shirt{" +
                "model='" + model + '\'' +
                ", name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", size='" + size + '\'' +
                '}';
    }
}
