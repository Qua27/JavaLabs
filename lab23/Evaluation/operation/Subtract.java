package ru.mirea.lab23.Evaluation.operation;

import ru.mirea.lab23.Evaluation.expression.TripleExpression;

public class Subtract extends Operation {
    public Subtract(TripleExpression left, TripleExpression right) {
        super(left, right);
    }

    protected int evaluate(int left, int right) {
        return left - right;
    }

    protected double evaluate(double left, double right) {
        return left - right;
    }
}
