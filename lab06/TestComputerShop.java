package ru.mirea.lab6;

import ru.mirea.lab4.TestComputer;

import java.util.ArrayList;
import java.util.Scanner;

public class TestComputerShop {
    public static void main(String[] args) {
        ComputerShop computerShop = new ComputerShop();
        computerShop.addComputer(TestComputer.Computer.HP);
        computerShop.addComputer(TestComputer.Computer.ASUS);
        computerShop.addComputer(TestComputer.Computer.LENOVO);
        System.out.println("What computer are you looking for?");
        Scanner scanner = new Scanner(System.in);
        String lookingFor = scanner.nextLine();
        TestComputer.Computer foundComputer = computerShop.searchComputer(lookingFor);
        scanner.close();
        if (foundComputer == null) {
            System.out.println("No such computer has been found");
            System.exit(1);
        }
        System.out.println("Your computer:");
        System.out.println(foundComputer);
    }
}

class ComputerShop {
    private final ArrayList<TestComputer.Computer> computers = new ArrayList<>();

    public void addComputer(TestComputer.Computer computer) {
        computers.add(computer);
    }

    public void removeComputer(TestComputer.Computer computer) {
        computers.remove(computer);
    }

    public TestComputer.Computer searchComputer(String model) {
        for (TestComputer.Computer computer : computers) {
            if (computer.name().equals(model)) {
                return computer;
            }
        }
        return null;
    }
}
