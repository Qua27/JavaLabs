package ru.mirea.lab4_1;

public class TestShapes {
    public static void main(String[] args) {
        Shape circle = new Circle(2);
        Shape rectangle = new Rectangle(1, 5);
        Shape square = new Square(5);
        System.out.println(circle.getArea());
        System.out.println(rectangle.getPerimeter());
        System.out.println(square.getType());
    }
}

class Shape {
    public String getType() {
        return "Shape";
    }

    double getArea() {
        return 0;
    }

    double getPerimeter() {
        return 0;
    }

    @Override
    public String toString() {
        return "Shape{}";
    }
}

class Circle extends Shape {
    private final double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public String getType() {
        return "Circle";
    }

    @Override
    double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                '}';
    }
}

class Rectangle extends Shape {
    private final double a, b;

    public Rectangle(double a, double b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public String getType() {
        return "Rectangle";
    }

    @Override
    double getArea() {
        return a * b;
    }

    @Override
    double getPerimeter() {
        return 2 * (a + b);
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "a=" + a +
                ", b=" + b +
                '}';
    }
}

class Square extends Shape {
    private final double a;

    public Square(double a) {
        this.a = a;
    }

    @Override
    public String getType() {
        return "Square";
    }

    @Override
    double getArea() {
        return a * a;
    }

    @Override
    double getPerimeter() {
        return 4 * a;
    }

    @Override
    public String toString() {
        return "Square{" +
                "a=" + a +
                '}';
    }
}
