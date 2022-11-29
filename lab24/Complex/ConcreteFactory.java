package ru.mirea.lab24.Complex;

public class ConcreteFactory implements ComplexAbstractFactory {
    @Override
    public Complex createComplex() {
        return new Complex();
    }

    @Override
    public Complex createComplex(int real, int imaginary) {
        return new Complex(real, imaginary);
    }
}
