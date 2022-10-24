package ru.mirea.lab4_1;

public abstract class Shape_ {
    protected String color;
    protected boolean isFilled;

    public Shape_() {
    }

    public Shape_(String color, boolean isFilled) {
        this.color = color;
        this.isFilled = isFilled;
    }

    public String getColor_() {
        return color;
    }

    public void setColor_(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return isFilled;
    }

    public void setFilled(boolean filled) {
        isFilled = filled;
    }

    abstract public double getArea_();

    abstract public double getPerimeter_();

    @Override
    public String toString() {
        return "Shape{" +
                "color='" + color + '\'' +
                ", isFilled=" + isFilled +
                '}';
    }
}

class Circle_ extends Shape_ {
    protected double radius;

    public Circle_() {
    }

    public Circle_(double radius) {
        this.radius = radius;
    }

    public Circle_(String color, boolean isFilled, double radius) {
        super(color, isFilled);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea_() {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public double getPerimeter_() {
        return 2 * Math.PI * radius;
    }

    @Override
    public String toString() {
        return "Circle_{" +
                "radius=" + radius +
                ", color='" + color + '\'' +
                ", isFilled=" + isFilled +
                '}';
    }
}

class Rectangle_ extends Shape_ {
    protected double width, length;

    public Rectangle_() {
    }

    public Rectangle_(double width, double length) {
        this.width = width;
        this.length = length;
    }

    public Rectangle_(String color, boolean isFilled, double width, double length) {
        super(color, isFilled);
        this.width = width;
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    @Override
    public double getArea_() {
        return width * length;
    }

    @Override
    public double getPerimeter_() {
        return 2 * (width + length);
    }

    @Override
    public String toString() {
        return "Rectangle_{" +
                "width=" + width +
                ", length=" + length +
                ", color='" + color + '\'' +
                ", isFilled=" + isFilled +
                '}';
    }
}

class Square_ extends Rectangle_ {
    protected double side;

    public Square_() {
    }

    public Square_(double side) {
        this.side = side;
    }

    public Square_(double side, String color, boolean isFilled, double width, double length) {
        super(color, isFilled, width, length);
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    @Override
    public double getWidth() {
        return side;
    }

    @Override
    public double getLength() {
        return side;
    }

    @Override
    public String toString() {
        return "Square_{" +
                "side=" + side +
                ", width=" + width +
                ", length=" + length +
                ", color='" + color + '\'' +
                ", isFilled=" + isFilled +
                '}';
    }
}
