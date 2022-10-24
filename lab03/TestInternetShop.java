package ru.mirea.lab3;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class TestInternetShop {
    public static void main(String[] args) {
        Product product1 = new Product();
        product1.setName("Pen");
        product1.setPrice(69.99);
        Product product2 = new Product();
        product2.setName("Pencil");
        product2.setPrice(19.99);
        ArrayList<Product> products = new ArrayList<>();
        products.add(product1);
        products.add(product2);
        InternetShop internetShop = new InternetShop();
        internetShop.setProducts(products);
        System.out.println("What are you willing to buy?");
        System.out.println("List of possible options:");
        internetShop.showProducts();
        Scanner scanner = new Scanner(System.in);
        String productChoice = scanner.nextLine();
        Product result = internetShop.searchProducts(productChoice);
        if (result != null) {
            System.out.println(result);
        } else {
            System.out.println("No such product found");
            scanner.close();
            System.exit(1);
        }
        System.out.println("Would you like to pay in\n1. USD\nor\n2. RUB\n?");
        int currencyChoice = scanner.nextInt();
        switch (currencyChoice) {
            case 1 ->
                    System.out.println("It'll be " + InternetShop.numberFormatUSD.format(CurrencyConverter.convertToUSD(result.getPrice())));
            case 2 -> System.out.printf("It'll be %f%s\n", result.getPrice(), InternetShop.RUB_SYMBOL);
            default -> {
                System.out.println("Incorrect input");
                System.exit(1);
            }
        }
    }
}

class Product {
    private String name;
    private double price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" + "name='" + name + '\'' + ", price=" + price + InternetShop.RUB_SYMBOL + '}';
    }
}

class InternetShop {
    static NumberFormat numberFormatUSD = NumberFormat.getCurrencyInstance(Locale.US);
    static final String RUB_SYMBOL = "\u20BD";
    private ArrayList<Product> products;

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public void showProducts() {
        System.out.print("| ");
        for (Product product : products) {
            System.out.print(product.getName() + " | ");
        }
        System.out.print('\n');
    }

    public Product searchProducts(String choice) {
        for (Product product : products) {
            if (product.getName().equals(choice)) {
                return product;
            }
        }
        return null;
    }
}
