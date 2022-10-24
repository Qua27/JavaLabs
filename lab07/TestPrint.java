package ru.mirea.lab7;

public class TestPrint {
    public static void main(String[] args) {
        Printable[] printables = new Printable[4];
        printables[0] = new Magazine("Science");
        printables[1] = new Book("Programming in Java");
        printables[2] = new Magazine("Nature");
        printables[3] = new Book("War and Peace");
        Magazine.print(printables);
        Book.print(printables);
    }
}

interface Printable {
}

class Magazine implements Printable {
    private final String name;

    public Magazine(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Magazine{" +
                "name='" + name + '\'' +
                '}';
    }

    public static void print(Printable[] printables) {
        for (Printable printable : printables) {
            if (printable instanceof Magazine) {
                System.out.println(printable);
            }
        }
    }
}

class Book implements Printable {
    private final String name;

    public Book(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                '}';
    }

    public static void print(Printable[] printables) {
        for (Printable printable : printables) {
            if (printable instanceof Book) {
                System.out.println(printable);
            }
        }
    }
}
