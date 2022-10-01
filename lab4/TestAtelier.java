package ru.mirea.lab4;

import java.util.ArrayList;

enum Size {
    XXS(32),
    XS(34),
    S(36),
    M(38),
    L(40);
    private final int euroSize;

    Size(int euroSize) {
        this.euroSize = euroSize;
    }

    public String getDescription() {
        if (this.equals(XXS)) {
            return "Детский размер";
        } else {
            return "Взрослый размер";
        }
    }

    @Override
    public String toString() {
        return "Size{" + this.name() +
                ", euroSize=" + euroSize +
                '}';
    }
}

interface MenClothing {
    void dressMan(ArrayList<Clothes> clothes);
}

interface WomenClothing {
    void dressWoman(ArrayList<Clothes> clothes);
}

abstract class Clothes {
    static final String RUB_SYMBOL = "\u20BD";
    private final Size size;
    private final double price;
    private final String color;

    public Clothes(Size size, double price, String color) {
        this.size = size;
        this.price = price;
        this.color = color;
    }

    public Size getSize() {
        return size;
    }

    public double getPrice() {
        return price;
    }

    public String getColor() {
        return color;
    }
}

class TShirt extends Clothes implements MenClothing, WomenClothing {

    public TShirt(Size size, double price, String color) {
        super(size, price, color);
    }

    @Override
    public void dressMan(ArrayList<Clothes> clothes) {

    }

    @Override
    public void dressWoman(ArrayList<Clothes> clothes) {

    }

    @Override
    public String toString() {
        return "TShirt{" +
                "size=" + super.getSize() +
                ", price=" + super.getPrice() + RUB_SYMBOL +
                ", color='" + super.getColor() + '\'' +
                '}';
    }
}

class Pants extends Clothes implements MenClothing, WomenClothing {

    public Pants(Size size, double price, String color) {
        super(size, price, color);
    }

    @Override
    public void dressMan(ArrayList<Clothes> clothes) {

    }

    @Override
    public void dressWoman(ArrayList<Clothes> clothes) {

    }

    @Override
    public String toString() {
        return "Pants{" +
                "size=" + super.getSize() +
                ", price=" + super.getPrice() + RUB_SYMBOL +
                ", color='" + super.getColor() + '\'' +
                '}';
    }
}

class Skirt extends Clothes implements WomenClothing {

    public Skirt(Size size, double price, String color) {
        super(size, price, color);
    }

    @Override
    public void dressWoman(ArrayList<Clothes> clothes) {

    }

    @Override
    public String toString() {
        return "Skirt{" +
                "size=" + super.getSize() +
                ", price=" + super.getPrice() + RUB_SYMBOL +
                ", color='" + super.getColor() + '\'' +
                '}';
    }
}

class Tie extends Clothes implements MenClothing {

    public Tie(Size size, double price, String color) {
        super(size, price, color);
    }

    @Override
    public void dressMan(ArrayList<Clothes> clothes) {

    }

    @Override
    public String toString() {
        return "Tie{" +
                "size=" + super.getSize() +
                ", price=" + super.getPrice() + RUB_SYMBOL +
                ", color='" + super.getColor() + '\'' +
                '}';
    }
}

class Atelier implements MenClothing, WomenClothing {

    @Override
    public void dressMan(ArrayList<Clothes> clothes) {
        for (Clothes element : clothes) {
            if (element instanceof MenClothing) {
                System.out.printf("%s | %s\n", element, element.getSize().getDescription());
            }
        }
    }

    @Override
    public void dressWoman(ArrayList<Clothes> clothes) {
        for (Clothes element : clothes) {
            if (element instanceof WomenClothing) {
                System.out.printf("%s | %s\n", element, element.getSize().getDescription());
            }
        }
    }
}

public class TestAtelier {
    public static void main(String[] args) {
        ArrayList<Clothes> clothes = new ArrayList<>();
        TShirt tShirt = new TShirt(Size.M, 249.99, "white");
        Pants pants = new Pants(Size.XS, 2099.99, "black");
        Skirt skirt = new Skirt(Size.L, 1599.99, "blue");
        Tie tie = new Tie(Size.S, 599.99, "brown");
        clothes.add(tShirt);
        clothes.add(pants);
        clothes.add(skirt);
        clothes.add(tie);
        Atelier atelier = new Atelier();
        atelier.dressMan(clothes);
        System.out.println();
        atelier.dressWoman(clothes);
    }
}
