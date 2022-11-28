package ru.mirea.lab23.Evaluation2.operation;

import ru.mirea.lab23.Evaluation2.expression.TripleExpression;

public abstract class Operation implements TripleExpression {
    private final TripleExpression left;
    private final TripleExpression right;

    public Operation(TripleExpression left, TripleExpression right) {
        this.left = left;
        this.right = right;
    }

    protected abstract int evaluate(int left, int right);

    public int evaluate(int x, int y, int z) {
        return evaluate(left.evaluate(x, y, z), right.evaluate(x, y, z));
    }
}
