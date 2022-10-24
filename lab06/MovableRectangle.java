package ru.mirea.lab6;

public class MovableRectangle implements Movable {
    private MovablePoint topLeft;
    private MovablePoint bottomRight;

    public MovableRectangle(int x1, int y1, int x2, int y2, int xSpeed, int ySpeed) {
        this.topLeft = new MovablePoint(x1, y1, xSpeed, ySpeed);
        this.bottomRight = new MovablePoint(x2, y2, xSpeed, ySpeed);
    }

    @Override
    public String toString() {
        return "MovableRectangle{" +
                "topLeft=" + topLeft +
                ", bottomRight=" + bottomRight +
                '}';
    }

    @Override
    public void moveUp() {

    }

    @Override
    public void moveDown() {

    }

    @Override
    public void moveLeft() {

    }

    @Override
    public void moveRight() {

    }

    public static double getFullSpeed(int xSpeed, int ySpeed) {
        return Math.sqrt(Math.pow(xSpeed, 2) + Math.pow(ySpeed, 2));
    }

    public boolean compareSpeeds(int xSpeed1, int ySpeed1, int xSpeed2, int ySpeed2) {
        double fullSpeed1 = getFullSpeed(xSpeed1, ySpeed1);
        double fullSpeed2 = getFullSpeed(xSpeed2, ySpeed2);
        return fullSpeed1 == fullSpeed2;
    }
}
