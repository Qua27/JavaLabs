package ru.mirea.lab3;

public class Wrappers {
    public static void main(String[] args) {
        Double d1 = Double.valueOf("3.14");
        String s1 = "1.414";
        double d2 = Double.parseDouble(s1);
        byte b1 = d1.byteValue();
        System.out.println("byte " + b1);
        short sh1 = d1.shortValue();
        System.out.println("short " + sh1);
        int i1 = d1.intValue();
        System.out.println("int " + i1);
        long l1 = d1.longValue();
        System.out.println("long " + l1);
        float f1 = d1.floatValue();
        System.out.println("float " + f1);
        System.out.println("Double " + d1);
        String s2 = Double.toString(d2);
    }
}
