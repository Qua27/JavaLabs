package ru.mirea.lab22;

public class IncorrectOperationException extends Exception {
    public IncorrectOperationException() {
        super("Incorrect operation sign passed");
    }
}
