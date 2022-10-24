package ru.mirea.lab6;

import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.Stack;

public class TestUndoCommandPattern {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        Stack<String> stringState = new Stack<>();
        Command delete1 = new Delete(stringBuilder, 0, 7);
        Command append1 = new Append(stringBuilder, "Hello");
        Command append2 = new Append(stringBuilder, "World");
        Command deleteCharAt1 = new DeleteCharAt(stringBuilder, 4);
        Command deleteCharAt2 = new DeleteCharAt(stringBuilder, 7);
        Command reverse = new Reverse(stringBuilder);
        MyStringBuilderExecutor myStringBuilderExecutor = new MyStringBuilderExecutor();
        myStringBuilderExecutor.register("delete1", delete1);
        myStringBuilderExecutor.register("append1", append1);
        myStringBuilderExecutor.register("append2", append2);
        myStringBuilderExecutor.register("deleteCharAt1", deleteCharAt1);
        myStringBuilderExecutor.register("deleteCharAt2", deleteCharAt2);
        myStringBuilderExecutor.register("reverse", reverse);
        Command undo = new Undo();
        myStringBuilderExecutor.register("undo", undo);
        myStringBuilderExecutor.execute("delete1", stringState);
        myStringBuilderExecutor.execute("append1", stringState);
        myStringBuilderExecutor.execute("append2", stringState);
        myStringBuilderExecutor.execute("deleteCharAt1", stringState);
        myStringBuilderExecutor.execute("deleteCharAt2", stringState);
        myStringBuilderExecutor.execute("reverse", stringState);
        System.out.println("Result string: " + stringBuilder);
        undo.execute(stringState);
        undo.execute(stringState);
        undo.execute(stringState);
        undo.execute(stringState);
        undo.execute(stringState);
        undo.execute(stringState);
    }
}

interface Command {
    void execute(Stack<String> stringState);
}

class MyStringBuilderExecutor {
    private final HashMap<String, Command> commandMap = new HashMap<>();

    public void register(String commandName, Command command) {
        commandMap.put(commandName, command);
    }

    public void execute(String commandName, Stack<String> stringState) {
        Command command = commandMap.get(commandName);
        if (command == null) {
            System.out.printf("No such command (%s) found registered", commandName);
        } else {
            command.execute(stringState);
        }
    }
}

class Undo implements Command {
    @Override
    public void execute(Stack<String> stringState) {
        try {
            stringState.pop();
            System.out.println("--------------------");
            System.out.println("Last operation undone");
            System.out.println("Current string: " + stringState.peek());
        } catch (EmptyStackException e) {
            System.out.println("Nothing to undo");
        }
    }
}

class Append implements Command {
    private final StringBuilder stringBuilder;
    private final Object object;

    public Append(StringBuilder stringBuilder, Object object) {
        this.stringBuilder = stringBuilder;
        this.object = object;
    }

    @Override
    public void execute(Stack<String> stringState) {
        stringBuilder.append(object);
        stringState.add(stringBuilder.toString());
    }
}

class Delete implements Command {
    private final StringBuilder stringBuilder;
    private final int start, end;

    public Delete(StringBuilder stringBuilder, int start, int end) {
        this.stringBuilder = stringBuilder;
        this.start = start;
        this.end = end;
    }

    @Override
    public void execute(Stack<String> stringState) {
        stringBuilder.delete(start, end);
        stringState.add(stringBuilder.toString());
    }
}

class DeleteCharAt implements Command {
    private final StringBuilder stringBuilder;
    private final int index;

    public DeleteCharAt(StringBuilder stringBuilder, int index) {
        this.stringBuilder = stringBuilder;
        this.index = index;
    }

    @Override
    public void execute(Stack<String> stringState) {
        stringBuilder.deleteCharAt(index);
        stringState.add(stringBuilder.toString());
    }
}

class Replace implements Command {
    private final StringBuilder stringBuilder;
    private final int start, end;
    private final String string;

    public Replace(StringBuilder stringBuilder, int start, int end, String string) {
        this.stringBuilder = stringBuilder;
        this.start = start;
        this.end = end;
        this.string = string;
    }

    @Override
    public void execute(Stack<String> stringState) {
        stringBuilder.replace(start, end, string);
        stringState.add(stringBuilder.toString());
    }
}

class Insert implements Command {
    private final StringBuilder stringBuilder;
    private final int offset;
    private final Object object;

    public Insert(StringBuilder stringBuilder, int offset, Object object) {
        this.stringBuilder = stringBuilder;
        this.offset = offset;
        this.object = object;
    }

    @Override
    public void execute(Stack<String> stringState) {
        stringBuilder.insert(offset, object);
        stringState.add(stringBuilder.toString());
    }
}

class Reverse implements Command {
    private final StringBuilder stringBuilder;

    public Reverse(StringBuilder stringBuilder) {
        this.stringBuilder = stringBuilder;
    }

    @Override
    public void execute(Stack<String> stringState) {
        stringBuilder.reverse();
        stringState.add(stringBuilder.toString());
    }
}
