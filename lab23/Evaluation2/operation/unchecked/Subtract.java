package ru.mirea.lab23.Evaluation2.operation.unchecked;

import ru.mirea.lab23.Evaluation2.expression.TripleExpression;
import ru.mirea.lab23.Evaluation2.operation.Operation;

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
