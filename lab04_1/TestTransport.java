package ru.mirea.lab4_1;

public class TestTransport {
    public static void main(String[] args) {
        Transport automobile = new Automobile(20, 200, 45, 300);
        Transport aeroplane = new Aeroplane(20, 200, 45, 300);
        Transport train = new Train(20, 200, 45, 300);
        Transport ship = new Ship(20, 200, 45, 300);
        System.out.printf("%s\n%s\n%s\n%s\n", automobile, aeroplane, train, ship);
    }
}

abstract class Transport {
    private final double passengerTime;
    private final double passengerPrice;
    private final double cargoTime;
    private final double cargoPrice;

    public Transport(double passengerTime, double passengerPrice, double cargoTime, double cargoPrice) {
        this.passengerTime = passengerTime;
        this.passengerPrice = passengerPrice;
        this.cargoTime = cargoTime;
        this.cargoPrice = cargoPrice;
    }

    @Override
    public String toString() {
        return "passengerTime=" + passengerTime +
                ", passengerPrice=" + passengerPrice +
                ", cargoTime=" + cargoTime +
                ", cargoPrice=" + cargoPrice +
                '}';
    }
}

class Automobile extends Transport {
    private static final int CAR_MULTIPLIER = 1;

    public Automobile(double passengerTime, double passengerPrice, double cargoTime, double cargoPrice) {
        super(passengerTime * CAR_MULTIPLIER, passengerPrice * CAR_MULTIPLIER, cargoTime * CAR_MULTIPLIER, cargoPrice * CAR_MULTIPLIER);
    }

    @Override
    public String toString() {
        return "Automobile{" + super.toString() + "}";
    }
}

class Aeroplane extends Transport {
    private static final int PLANE_MULTIPLIER = 4;

    public Aeroplane(double passengerTime, double passengerPrice, double cargoTime, double cargoPrice) {
        super(passengerTime * PLANE_MULTIPLIER, passengerPrice * PLANE_MULTIPLIER, cargoTime * PLANE_MULTIPLIER, cargoPrice * PLANE_MULTIPLIER);
    }

    @Override
    public String toString() {
        return "Aeroplane{" + super.toString() + "}";
    }
}

class Train extends Transport {
    private static final int TRAIN_MULTIPLIER = 2;

    public Train(double passengerTime, double passengerPrice, double cargoTime, double cargoPrice) {
        super(passengerTime * TRAIN_MULTIPLIER, passengerPrice * TRAIN_MULTIPLIER, cargoTime * TRAIN_MULTIPLIER, cargoPrice * TRAIN_MULTIPLIER);
    }

    @Override
    public String toString() {
        return "Train{" + super.toString() + "}";
    }
}

class Ship extends Transport {
    private static final double SHIP_MULTIPLIER = 3;

    public Ship(double passengerTime, double passengerPrice, double cargoTime, double cargoPrice) {
        super(passengerTime * SHIP_MULTIPLIER, passengerPrice * SHIP_MULTIPLIER, cargoTime * SHIP_MULTIPLIER, cargoPrice * SHIP_MULTIPLIER);
    }

    @Override
    public String toString() {
        return "Ship{" + super.toString() + "}";
    }
}
