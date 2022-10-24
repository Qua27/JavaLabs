package ru.mirea.lab4_1;

public class TestReader {
    public static void main(String[] args) {
        Book book1 = new Book("Adventures", "Author1");
        Book book2 = new Book("Dictionary", "Author2");
        Book book3 = new Book("Encyclopedia", "Author3");
        Reader reader = new Reader("Petrov V. V.");
        reader.takeBook(3);
        reader.takeBook(book1, book2, book3);
        reader.returnBook(book1, book2, book3);
        reader.returnBook(3);
    }
}

class Reader {
    private String full_name;
    private int readerId;
    private String faculty;
    private String birthDate;
    private String phoneNumber;

    public Reader(String full_name) {
        this.full_name = full_name;
    }

    public void takeBook(int n) {
        System.out.printf("%s took %d books\n", full_name, n);
    }

    public void takeBook(Book... books) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(full_name);
        stringBuilder.append(" took: ");
        for (Book book : books) {
            stringBuilder.append(book);
            stringBuilder.append(", ");
        }
        System.out.println(stringBuilder);
    }

    public void returnBook(int n) {
        System.out.printf("%s returned %d books\n", full_name, n);
    }

    public void returnBook(Book... books) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(full_name);
        stringBuilder.append(" returned: ");
        for (Book book : books) {
            stringBuilder.append(book);
            stringBuilder.append(", ");
        }
        System.out.println(stringBuilder);
    }
}

class Book {
    private String name;
    private String author;

    public Book(String name) {
        this.name = name;
    }

    public Book(String name, String author) {
        this(name);
        this.author = author;
    }

    @Override
    public String toString() {
        return name;
    }
}
