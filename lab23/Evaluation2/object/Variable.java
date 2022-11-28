package ru.mirea.lab23.Evaluation2.object;

import ru.mirea.lab23.Evaluation2.expression.TripleExpression;

public class Variable implements TripleExpression {
    private final String name;

    public Variable(String name) {
        this.name = name;
    }

    public int evaluate(int x, int y, int z) {
        return name.equals("x") ? x : name.equals("y") ? y : name.equals("z") ? z : 0;
    }
}
