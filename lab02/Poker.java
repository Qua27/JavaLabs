package ru.mirea.lab2;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Poker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of players:");
        int n = scanner.nextInt();
        scanner.close();
        if (n > 9) {
            System.out.println("The deck is not enough");
            System.exit(1);
        }
        ArrayList<Card> deck = new ArrayList<>();
        Random random = new Random();
        for (int suit = 1; suit <= 4; suit++) {
            for (int v = 2; v <= 14; v++) {
                deck.add(new Card(suit, v));
            }
        }
        for (int j = 0; j < 5 * n; j++) {
            if (j % 5 == 0) {
                System.out.println();
            }
            int index = random.nextInt(0, deck.size());
            System.out.println(deck.get(index));
            deck.remove(index);
        }
    }
}

class Card {
    private final int suit, value;
    private final static char[] HIGH_SUITS_SYMBOLS = {'J', 'Q', 'K', 'A'};
    private final static String[] SUITS_NAMES = {"Hearts", "Tiles", "Clovers", "Pikes"};

    public Card(int suit, int value) {
        this.suit = suit;
        this.value = value;
    }

    @Override
    public String toString() {
        if (value > 10) {
            return SUITS_NAMES[suit - 1] + ", " + HIGH_SUITS_SYMBOLS[value - 11];
        }
        return SUITS_NAMES[suit - 1] + ", " + value;
    }
}
