package ru.mirea.lab4_1;

public class TestWorkers {
    public static void main(String[] args) {
        Employer manager = new Manager("Wade", "Scott", 80000, 8000);
        Employer employer = new Employer("Wilson", "Smith", 80000);
        System.out.println(manager.getIncome() + "\n");
        Employer[] employers = {manager, employer};
        for (Employer employer1 : employers) {
            System.out.println(employer1.getIncome());
        }
    }
}

class Employer {
    private String firstName;
    private String lastName;
    private double income;

    public Employer(String firstName, String lastName, double income) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.income = income;
    }

    public double getIncome() {
        return income;
    }
}

class Manager extends Employer {
    private double averageSum;

    public Manager(String firstName, String lastName, double income, double averageSum) {
        super(firstName, lastName, income);
        this.averageSum = averageSum;
    }

    @Override
    public double getIncome() {
        return super.getIncome() + averageSum * 12;
    }
}
