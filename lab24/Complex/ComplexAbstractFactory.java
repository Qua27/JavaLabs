package ru.mirea.lab24.Complex;

public interface ComplexAbstractFactory {
    Complex createComplex();

    Complex createComplex(int real, int imaginary);
}
