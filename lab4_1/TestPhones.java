package ru.mirea.lab4_1;

public class TestPhones {
    public static void main(String[] args) {
        Phone phone1 = new Phone("+79150345673", "Samsung", 100.5);
        Phone phone2 = new Phone("+79140223652", "IPhone", 130.1);
        Phone phone3 = new Phone("+79220787661", "Xiaomi", 110.3);
        System.out.printf("%s\n%s\n%s\n", phone1, phone2, phone3);
        phone1.receiveCall("Bob");
        System.out.println(phone2.getNumber());
        phone3.receiveCall("Bob", "+79140223652");
        phone1.sendMessage("+79140223652", "+79220787661");
    }
}

class Phone {
    private String number;
    private String model;
    private double weight;

    public Phone() {
    }

    public Phone(String number, String model) {
        this();
        this.number = number;
        this.model = model;
    }

    public Phone(String number, String model, double weight) {
        this(number, model);
        this.weight = weight;
    }

    public String getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "number='" + number + '\'' +
                ", model='" + model + '\'' +
                ", weight=" + weight +
                '}';
    }

    public void receiveCall(String name) {
        System.out.printf("Звонит {%s}\n", name);
    }

    public void receiveCall(String name, String number) {
        System.out.printf("Звонит {%s, %s}\n", name, number);
    }

    public void sendMessage(String... numbers) {
        for (String number : numbers) {
            System.out.println(number);
        }
    }
}
