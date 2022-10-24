package ru.mirea.lab3;

import java.util.ArrayList;

public class TestReport {
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();
        Employee employee1 = new Employee();
        employee1.setFullName("Bob");
        employee1.setSalary(25000);
        Employee employee2 = new Employee();
        employee2.setFullName("Rob");
        employee2.setSalary(75000);
        Employee employee3 = new Employee();
        employee3.setFullName("Leo");
        employee3.setSalary(125000);
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
        Report.generateReport(employees);
    }
}

class Employee {
    private String fullName;
    private double salary;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}

class Report {
    public static void generateReport(ArrayList<Employee> employees) {
        for (Employee employee : employees) {
            System.out.printf("%-5s %10.2f%n", employee.getFullName(), employee.getSalary());
        }
    }
}
