package ru.mirea.lab8;

import java.util.Scanner;

public class TestMaximumOccurrencesCounter {

    private static SequenceElement countMaximumOccurrences() {
        return countMaximumOccurrences(new SequenceElement(0, 0));
    }

    private static SequenceElement countMaximumOccurrences(SequenceElement sequenceElement) {
        Scanner scanner = new Scanner(System.in);
        SequenceElement nextElement = new SequenceElement();
        int x = scanner.nextInt();
        if (x > sequenceElement.getValue()) {
            nextElement.setValue(x);
            nextElement.setOccurrencesNumber(1);
        } else if (x == sequenceElement.getValue()) {
            nextElement.setValue(x);
            nextElement.setOccurrencesNumber(sequenceElement.getOccurrencesNumber() + 1);
        } else {
            nextElement = sequenceElement;
        }
        if (x == 0) {
            return sequenceElement;
        }
        return countMaximumOccurrences(nextElement);
    }

    public static void main(String[] args) {
        System.out.println("Enter the sequence of numbers (enter 0 in the end):");
        System.out.println(countMaximumOccurrences());
    }
}

class SequenceElement {
    private int value, occurrencesNumber;

    public SequenceElement() {
    }

    public SequenceElement(int value, int occurrencesNumber) {
        this.value = value;
        this.occurrencesNumber = occurrencesNumber;
    }

    public int getValue() {
        return value;
    }

    public int getOccurrencesNumber() {
        return occurrencesNumber;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setOccurrencesNumber(int occurrencesNumber) {
        this.occurrencesNumber = occurrencesNumber;
    }

    @Override
    public String toString() {
        return "SequenceElement{" +
                "value=" + value +
                ", occurrencesNumber=" + occurrencesNumber +
                '}';
    }
}
