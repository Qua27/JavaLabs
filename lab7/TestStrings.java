package ru.mirea.lab7;

public class TestStrings {
    public static void main(String[] args) {
        String string = "Hello World!";
        StringOperable processStrings = new ProcessStrings();
        System.out.println(processStrings.length(string));
        System.out.println(processStrings.getStringFromCharsAtOddIndexes(string));
        System.out.println(processStrings.reverseString(string));
    }
}

interface StringOperable {
    int length(String string);

    String getStringFromCharsAtOddIndexes(String string);

    String reverseString(String string);
}

class ProcessStrings implements StringOperable {
    @Override
    public int length(String string) {
        return string.length();
    }

    @Override
    public String getStringFromCharsAtOddIndexes(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i < string.length(); i += 2) {
            stringBuilder.append(string.charAt(i));
        }
        return stringBuilder.toString();
    }

    @Override
    public String reverseString(String string) {
        return new StringBuilder(string).reverse().toString();
    }
}
