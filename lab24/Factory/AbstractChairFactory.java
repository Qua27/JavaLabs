package ru.mirea.lab24.Factory;

public interface AbstractChairFactory {
    Chair createVictorianChair(int age);

    Chair createMagicChair();

    Chair createFunctionalChair();
}
