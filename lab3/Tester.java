package ru.mirea.lab3;

import java.util.Arrays;
import java.util.Random;

public class Tester {
    public static void main(String[] args) {
        Point point = new Point();
        point.setX(0);
        point.setY(0);
        Random random = new Random();
        Circle circle1 = new Circle();
        circle1.setCenter(point);
        circle1.setRadius(random.nextDouble());
        Circle circle2 = new Circle();
        circle2.setCenter(point);
        circle2.setRadius(random.nextDouble());
        Circle circle3 = new Circle();
        circle3.setCenter(point);
        circle3.setRadius(random.nextDouble());
        Circle circle4 = new Circle();
        circle4.setCenter(point);
        circle4.setRadius(random.nextDouble());
        Container container = new Container();
        int size = 4;
        Circle[] circles = new Circle[size];
        circles[0] = circle1;
        circles[1] = circle2;
        circles[2] = circle3;
        circles[3] = circle4;
        container.setCircles(circles);
        container.setSize(size);
        System.out.println(Arrays.toString(container.getCircles()));
        container.sortCircles();
        System.out.println(Arrays.toString(container.getCircles()));
    }
}

class Container {
    private Circle[] circles;
    private int size;

    public Circle[] getCircles() {
        return circles;
    }

    public void setCircles(Circle[] circles) {
        this.circles = circles;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void sortCircles() {
        Arrays.sort(circles);
    }
}

class Point {
    private double x, y;

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}

class Circle implements Comparable<Circle> {
    private Point center;
    private double radius;

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "center=" + center +
                ", radius=" + radius +
                '}';
    }

    @Override
    public int compareTo(Circle o) {
        return Double.compare(radius, o.radius);
    }
}
