package ru.mirea.lab24.Factory;

public class ChairFactory implements AbstractChairFactory {
    @Override
    public Chair createVictorianChair(int age) {
        return new VictorianChair(age);
    }

    @Override
    public Chair createMagicChair() {
        return new MagicChair();
    }

    @Override
    public Chair createFunctionalChair() {
        return new FunctionalChair();
    }
}
