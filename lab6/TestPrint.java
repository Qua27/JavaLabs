package ru.mirea.lab6;

import java.util.ArrayList;

interface Printable {
    void print();
}

public class TestPrint {
    public static void main(String[] args) {
        Book_ book1 = new Book_("Algebra");
        Book_ book2 = new Book_("Calculus");
        Book_ book3 = new Book_("Physics");
        ArrayList<Book_> books = new ArrayList<>();
        books.add(book1);
        books.add(book2);
        books.add(book3);
        Printable shop = new Shop(books);
        shop.print();
    }

}

class Book_ implements Printable {
    private String title;

    public Book_(String title) {
        this.title = title;
    }

    @Override
    public void print() {
        System.out.println(title);
    }
}

class Shop implements Printable {
    private ArrayList<Book_> books;

    public Shop(ArrayList<Book_> books) {
        this.books = books;
    }

    @Override
    public void print() {
        for (Book_ book : books) {
            book.print();
        }
    }
}
