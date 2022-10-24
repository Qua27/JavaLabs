package ru.mirea.lab2;

import java.lang.Math;

public class TestCircle {
    public static void main(String[] args) {
        Circle circle1 = new Circle(2);
        Circle circle2 = new Circle(4);
        System.out.println("Area = " + circle1.getArea());
        System.out.println("Circumference = " + circle1.getCircumference());
        System.out.println(circle1.compareTo(circle2));
    }
}

class Circle implements Comparable<Circle> {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    public double getCircumference() {
        return 2 * Math.PI * radius;
    }

    @Override
    public int compareTo(Circle o) {
        return Double.compare(this.radius, o.radius);
    }
}
