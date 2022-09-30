package ru.mirea.lab2;

import java.util.Arrays;
import java.util.Comparator;

public class TestBook {
    public static void main(String[] args) {
        Book book1 = new Book("Ted", "Python", 2021);
        Book book2 = new Book("Red", "Java", 2019);
        Book book3 = new Book("William", "C", 1997);
        int size = 3;
        Book[] books = new Book[size];
        books[0] = book1;
        books[1] = book2;
        books[2] = book3;
        BookShelf bookShelf = new BookShelf(books, size);
        System.out.printf("There is %d books on the shelf\n", bookShelf.getN());
        System.out.println("\nBefore sorting:");
        System.out.println(Arrays.toString(bookShelf.getBooks()));
        Arrays.sort(books, Book.getBookComparator());
        System.out.println("\nAfter sorting:");
        System.out.println(Arrays.toString(bookShelf.getBooks()));
    }
}

class Book {
    private String author;
    private String title;
    private int year;
    private static final Comparator<Book> bookComparator = Comparator.comparing(Book::getYear);

    public Book(String author, String title, int year) {
        this.author = author;
        this.title = title;
        this.year = year;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public static Comparator<Book> getBookComparator() {
        return bookComparator;
    }

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", year=" + year +
                '}';
    }
}

class BookShelf {
    private final Book[] books;
    private final int n;

    public BookShelf(Book[] books, int n) {
        this.books = books;
        this.n = n;
    }

    public Book[] getBooks() {
        return books;
    }

    public int getN() {
        return n;
    }
}
