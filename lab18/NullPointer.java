package ru.mirea.lab18;

public class NullPointer {
    public static void main(String[] args) {
        ThrowsDemo1 throwsDemo = new ThrowsDemo1();
        String key1 = "name";
        String key2 = null;
        throwsDemo.printMessage(key1);
        throwsDemo.printMessage(key2);
    }
}

class ThrowsDemo1 {
    public void printMessage(String key) {
        try {
            String message = getDetails(key);
            System.out.println(message);
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }

    public String getDetails(String key) {
        if (key == null) {
            throw new NullPointerException("Null key passed to getDetails");
        }
        return "data for " + key;
    }
}
