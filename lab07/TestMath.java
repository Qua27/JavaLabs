package ru.mirea.lab7;

public class TestMath {
    public static void main(String[] args) {
        Complex complex1 = new Complex(1, 2);
        MathCalculable mathFunc = new MathFunc();
        System.out.println(mathFunc.abs(complex1));
        double radius = 2;
        double circumference = 2 * MathFunc.PI * radius;
        System.out.println(circumference);
    }
}

class Complex {
    private final double x, y;

    public Complex(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}

interface MathCalculable {
    double PI = 3.14159265358979;

    double pow(double x, double n);

    double abs(Complex complex);
}

class MathFunc implements MathCalculable {

    @Override
    public double pow(double x, double n) {
        return Math.pow(x, n);
    }

    @Override
    public double abs(Complex complex) {
        return Math.sqrt(pow(complex.getX(), 2) + pow(complex.getY(), 2));
    }
}
