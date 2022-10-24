package ru.mirea.lab6;

interface Priceable {
    double getPrice();
}

public class TestPrice {
    public static void main(String[] args) {
        Priceable bread = new Food(44.99);
        Priceable book = new Book(659.99);
        System.out.println(bread.getPrice());
        System.out.println(book.getPrice());
    }
}

class Food implements Priceable {
    private double price;

    public Food(double price) {
        this.price = price;
    }

    @Override
    public double getPrice() {
        return price;
    }
}

class Book implements Priceable {
    private double price;

    public Book(double price) {
        this.price = price;
    }

    @Override
    public double getPrice() {
        return price;
    }
}
