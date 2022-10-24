package ru.mirea.lab6;

import java.util.EmptyStackException;
import java.util.Stack;

public class TestUndo {
    public static void main(String[] args) {
        MyStringBuilder myStringBuilder = new MyStringBuilder("Example");
        myStringBuilder.delete(0, 7);
        myStringBuilder.append("Hello").append("World").deleteCharAt(4).deleteCharAt(7);
        myStringBuilder.reverse();
        System.out.println("Result string: " + myStringBuilder);
        System.out.println("All versions of string during operations: " + myStringBuilder.getStringState());
        System.out.println("History of operations (names only): " + myStringBuilder.getCommandName());
        myStringBuilder.undo();
        myStringBuilder.undo();
        myStringBuilder.undo();
        myStringBuilder.undo();
        myStringBuilder.undo();
        myStringBuilder.undo();
        myStringBuilder.undo();
    }
}

class MyStringBuilder {
    private final StringBuilder stringBuilder = new StringBuilder();
    private final Stack<String> commandName = new Stack<>();
    private final Stack<String> stringState = new Stack<>();

    public MyStringBuilder() {
    }

    public MyStringBuilder(String string) {
        stringBuilder.append(string);
        stringState.add(string);
    }

    public Stack<String> getCommandName() {
        return commandName;
    }

    public Stack<String> getStringState() {
        return stringState;
    }

    public void undo() {
        System.out.println("--------------------");
        try {
            System.out.printf("%s undone\n", commandName.pop());
            stringState.pop();
            System.out.println("Current string: " + stringState.peek());
        } catch (EmptyStackException e) {
            System.out.println("Nothing to undo");
        }
    }

    public MyStringBuilder append(Object obj) {
        commandName.add("append");
        stringBuilder.append(obj);
        stringState.add(this.toString());
        return this;
    }

    public MyStringBuilder delete(int start, int end) {
        commandName.add("delete");
        stringBuilder.delete(start, end);
        stringState.add(this.toString());
        return this;
    }

    public MyStringBuilder deleteCharAt(int index) {
        commandName.add("deleteCharAt");
        stringBuilder.deleteCharAt(index);
        stringState.add(this.toString());
        return this;
    }

    public MyStringBuilder replace(int start, int end, String str) {
        commandName.add("replace");
        stringBuilder.replace(start, end, str);
        stringState.add(this.toString());
        return this;
    }

    public MyStringBuilder insert(int offset, Object obj) {
        commandName.add("insert");
        stringBuilder.insert(offset, obj);
        stringState.add(this.toString());
        return this;
    }

    public MyStringBuilder reverse() {
        commandName.add("reverse");
        stringBuilder.reverse();
        stringState.add(this.toString());
        return this;
    }

    @Override
    public String toString() {
        return stringBuilder.toString();
    }
}
