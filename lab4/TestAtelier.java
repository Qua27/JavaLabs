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

    enum Gender {
        MALE,
        FEMALE,
        BOTH
    }

    private Size size;
    private double price;
    private String color;

    abstract public Gender getClothesGender();

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}

class TShirt extends Clothes implements MenClothing, WomenClothing {

    @Override
    public Gender getClothesGender() {
        return Gender.BOTH;
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

    @Override
    public Gender getClothesGender() {
        return Gender.BOTH;
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

    @Override
    public Gender getClothesGender() {
        return Gender.FEMALE;
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

    @Override
    public Gender getClothesGender() {
        return Gender.MALE;
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
            if (element.getClothesGender() == Clothes.Gender.MALE || element.getClothesGender() == Clothes.Gender.BOTH) {
                System.out.printf("%s | %s\n", element, element.getSize().getDescription());
            }
        }
    }

    @Override
    public void dressWoman(ArrayList<Clothes> clothes) {
        for (Clothes element : clothes) {
            if (element.getClothesGender() == Clothes.Gender.FEMALE || element.getClothesGender() == Clothes.Gender.BOTH) {
                System.out.printf("%s | %s\n", element, element.getSize().getDescription());
            }
        }
    }
}

public class TestAtelier {
    public static void main(String[] args) {
        ArrayList<Clothes> clothes = new ArrayList<>();
        TShirt tShirt = new TShirt();
        tShirt.setSize(Size.M);
        tShirt.setPrice(249.99);
        tShirt.setColor("white");
        Pants pants = new Pants();
        pants.setSize(Size.XS);
        pants.setPrice(2099.99);
        pants.setColor("black");
        Skirt skirt = new Skirt();
        skirt.setSize(Size.L);
        skirt.setPrice(1599.99);
        skirt.setColor("blue");
        Tie tie = new Tie();
        tie.setSize(Size.S);
        tie.setPrice(599.99);
        tie.setColor("brown");
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
