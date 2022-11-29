package ru.mirea.lab24.Factory;

public class Client {
    public Chair chair;

    public void setChair(Chair chair) {
        this.chair = chair;
    }

    public void sit() {
        System.out.println("Client sat on the chair");
    }
}
