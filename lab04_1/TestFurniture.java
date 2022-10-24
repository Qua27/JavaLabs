package ru.mirea.lab4_1;

import java.util.ArrayList;
import java.util.Collections;

public class TestFurniture {
    public static void initializeShop(FurnitureShop furnitureShop) {
        Furniture chair = new Chair(30, 20, 80, 3.2);
        Furniture table = new Table(120, 60, 80);
        Furniture wardrobe = new Wardrobe(100, 60, 200);
        furnitureShop.addFurniture(chair, table, wardrobe);
    }

    public static void main(String[] args) {
        FurnitureShop furnitureShop = new FurnitureShop();
        initializeShop(furnitureShop);
        for (Furniture furniture : furnitureShop.getFurnitureArrayList()) {
            System.out.println(furniture);
        }
    }
}

abstract class Furniture {
    private final double length, width, height;

    public Furniture(double length, double width, double height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return "length=" + length +
                ", width=" + width +
                ", height=" + height +
                '}';
    }
}

class Chair extends Furniture {
    private final double comfortIndex;

    public Chair(double length, double width, double height, double comfortIndex) {
        super(length, width, height);
        this.comfortIndex = comfortIndex;
    }

    @Override
    public String toString() {
        return "Chair{" +
                "comfortIndex=" + comfortIndex +
                " " + super.toString();
    }
}

class Table extends Furniture {
    public Table(double length, double width, double height) {
        super(length, width, height);
    }

    public double getArea() {
        return super.getLength() * super.getWidth();
    }

    @Override
    public String toString() {
        return "Table{" +
                "area=" + getArea() +
                " " + super.toString();
    }
}

class Wardrobe extends Furniture {
    public Wardrobe(double length, double width, double height) {
        super(length, width, height);
    }

    public double getSpace() {
        return super.getWidth() * super.getLength() * super.getHeight();
    }

    @Override
    public String toString() {
        return "Wardrobe{" +
                "space=" + getSpace() +
                " " + super.toString();
    }
}

class FurnitureShop {
    private final ArrayList<Furniture> furnitureArrayList = new ArrayList<>();

    public ArrayList<Furniture> getFurnitureArrayList() {
        return furnitureArrayList;
    }

    public void addFurniture(Furniture... piecesOfFurniture) {
        Collections.addAll(furnitureArrayList, piecesOfFurniture);
    }
}
