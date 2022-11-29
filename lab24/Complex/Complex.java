package ru.mirea.lab24.Complex;

public class Complex {
    private int real, imaginary;

    public Complex() {
    }

    public Complex(int a, int b) {
        this.real = a;
        this.imaginary = b;
    }

    public int getReal() {
        return real;
    }

    public void setReal(int real) {
        this.real = real;
    }

    public int getImaginary() {
        return imaginary;
    }

    public void setImaginary(int imaginary) {
        this.imaginary = imaginary;
    }

    @Override
    public String toString() {
        return real + " + i" + imaginary;
    }
}
