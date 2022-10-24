package ru.mirea.lab4;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TestInternetShop {
    enum Product {
        PHYSICS(1399.99),
        MATHS(899.99),
        CHEMISTRY(849.99),
        CRIME_AND_PUNISHMENT(599.99),
        WAR_AND_PEACE(1699.99),
        FATHERS_AND_SONS(799.99),
        BREAD(44.99),
        MILK(129.99),
        EGGS(89.99);
        private final double price;
        static final String RUB_SYMBOL = "\u20BD";

        Product(double price) {
            this.price = price;
        }

        public double getPrice() {
            return price;
        }

        @Override
        public String toString() {
            return this.name() + ", " + price + RUB_SYMBOL;
        }
    }

    public static void initializeInternetShop(InternetShop internetShop) {
        ProductCatalog scientificBooks = new ProductCatalog();
        scientificBooks.setName("Scientific Books");
        scientificBooks.addProduct(Product.PHYSICS);
        scientificBooks.addProduct(Product.MATHS);
        scientificBooks.addProduct(Product.CHEMISTRY);
        ProductCatalog nonScientificBooks = new ProductCatalog();
        nonScientificBooks.setName("Fiction Books");
        nonScientificBooks.addProduct(Product.CRIME_AND_PUNISHMENT);
        nonScientificBooks.addProduct(Product.WAR_AND_PEACE);
        nonScientificBooks.addProduct(Product.FATHERS_AND_SONS);
        ProductCatalog foodStuff = new ProductCatalog();
        foodStuff.setName("Food Stuff");
        foodStuff.addProduct(Product.BREAD);
        foodStuff.addProduct(Product.MILK);
        foodStuff.addProduct(Product.EGGS);
        internetShop.addCatalog(scientificBooks);
        internetShop.addCatalog(nonScientificBooks);
        internetShop.addCatalog(foodStuff);
    }

    public static void main(String[] args) {
        User user1 = new User();
        user1.setLogin("user1");
        user1.setPassword("user123");
        user1.setBalance(10000);
        InternetShop internetShop = new InternetShop();
        initializeInternetShop(internetShop);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter login:");
        String login = scanner.nextLine();
        while (!login.equals(user1.getLogin())) {
            System.out.println("Incorrect login. Try again");
            login = scanner.nextLine();
        }
        System.out.println("Enter password:");
        String password = scanner.nextLine();
        while (!password.equals(user1.getPassword())) {
            System.out.println("Incorrect password. Try again");
            password = scanner.nextLine();
        }
        System.out.printf("Welcome, %s! Your current balance is %.2f%s\n", user1.getLogin(), user1.getBalance(), Product.RUB_SYMBOL);
        Cart cart = new Cart();
        while (true) {
            try {
                internetShop.printCatalogs();
                System.out.println("0. To cart");
                System.out.println("-1. Exit");
                System.out.println("Choose a catalog:");
                int choice;
                choice = scanner.nextInt();
                if (choice == -1) {
                    System.exit(1);
                }
                if (choice == 0) {
                    if (cart.getProducts().size() == 0) {
                        System.out.println("You have nothing in cart, add something first");
                        continue;
                    }
                    System.out.println("Your cart:");
                    cart.printCart();
                    System.out.printf("Total: %.2f%s\n", cart.getTotal(), Product.RUB_SYMBOL);
                    System.out.println("Do you want to purchase? (1 - yes; 0 - no)\nPress -2 if you want to remove something from your cart");
                    choice = scanner.nextInt();
                    if (choice == 0) {
                        continue;
                    } else if (choice == 1) {
                        break;
                    } else if (choice == -2) {
                        System.out.println("What do you want to remove from your cart?");
                        cart.printCart();
                        choice = scanner.nextInt();
                        CartProduct productToRemove = cart.getProducts().get(choice - 1);
                        cart.removeProduct(productToRemove);
                        cart.subtractFromTotal(productToRemove.getQuantity() * productToRemove.getProduct().getPrice());
                        continue;
                    } else {
                        System.out.println("Incorrect input");
                        System.exit(1);
                    }
                }
                ProductCatalog chosenCatalog = internetShop.getCatalogs().get(choice - 1);
                chosenCatalog.printCatalog();
                System.out.println("-1. Go back to catalogs");
                System.out.println("Choose a product:");
                choice = scanner.nextInt();
                if (choice == -1) {
                    continue;
                }
                Product chosenProduct = chosenCatalog.getProducts().get(choice - 1);
                int quantity;
                System.out.println("Enter quantity:");
                quantity = scanner.nextInt();
                boolean isAlreadyInCart = false;
                boolean isQuantityNegative = false;
                for (CartProduct product : cart.getProducts()) {
                    if (product.getProduct().name().equals(chosenProduct.name())) {
                        isAlreadyInCart = true;
                        if (product.getQuantity() + quantity < 0) {
                            System.out.println("You don't have enough products to subtract");
                            isQuantityNegative = true;
                        } else if (product.getQuantity() + quantity == 0) {
                            cart.removeProduct(product);
                        } else {
                            product.setQuantity(product.getQuantity() + quantity);
                        }
                        break;
                    }
                }
                if (!isAlreadyInCart) {
                    if (quantity < 0) {
                        System.out.println("You don't have enough products to subtract");
                        continue;
                    }
                    CartProduct cartProduct = new CartProduct();
                    cartProduct.setProduct(chosenProduct);
                    cartProduct.setQuantity(quantity);
                    cart.addProduct(cartProduct);
                }
                if (!isQuantityNegative) {
                    cart.addToTotal(chosenProduct.getPrice() * quantity);
                }
            } catch (InputMismatchException | IndexOutOfBoundsException e) {
                System.out.println("Incorrect input");
                System.exit(1);
            }
        }
        user1.setBalance(user1.getBalance() - cart.getTotal());
        System.out.printf("Your current balance: %.2f%s", user1.getBalance(), Product.RUB_SYMBOL);
        scanner.close();
    }
}

class User {
    private String login;
    private String password;
    private double balance;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}

class ProductCatalog {
    private String name;
    private final ArrayList<TestInternetShop.Product> products = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<TestInternetShop.Product> getProducts() {
        return products;
    }

    public void addProduct(TestInternetShop.Product product) {
        products.add(product);
    }

    public void printCatalog() {
        int i = 1;
        for (TestInternetShop.Product product : products) {
            System.out.printf("%d. %s\n", i, product);
            i++;
        }
    }
}

class CartProduct {
    private TestInternetShop.Product product;
    private int quantity;

    public TestInternetShop.Product getProduct() {
        return product;
    }

    public void setProduct(TestInternetShop.Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

class Cart {
    private final ArrayList<CartProduct> products = new ArrayList<>();

    public ArrayList<CartProduct> getProducts() {
        return products;
    }

    public void addProduct(CartProduct product) {
        products.add(product);
    }

    public void removeProduct(CartProduct product) {
        products.remove(product);
    }

    private double total;

    public double getTotal() {
        return total;
    }

    public void addToTotal(double price) {
        this.total += price;
    }

    public void subtractFromTotal(double price) {
        this.total -= price;
    }

    public void printCart() {
        int i = 1;
        for (CartProduct product : products) {
            System.out.printf("%d. %s %d x %.2f%s\n", i, product.getProduct().name(), product.getQuantity(), product.getProduct().getPrice(), TestInternetShop.Product.RUB_SYMBOL);
            i++;
        }
    }
}

class InternetShop {
    private final ArrayList<ProductCatalog> catalogs = new ArrayList<>();

    public ArrayList<ProductCatalog> getCatalogs() {
        return catalogs;
    }

    public void addCatalog(ProductCatalog productCatalog) {
        catalogs.add(productCatalog);
    }

    public void printCatalogs() {
        int i = 1;
        for (ProductCatalog productCatalog : catalogs) {
            System.out.printf("%d. %s\n", i, productCatalog.getName());
            i++;
        }
    }
}
