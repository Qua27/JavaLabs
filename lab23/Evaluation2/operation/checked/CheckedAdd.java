package ru.mirea.lab23.Evaluation2.operation.checked;

import ru.mirea.lab23.Evaluation2.exceptions.ArithmeticParserException;
import ru.mirea.lab23.Evaluation2.expression.TripleExpression;
import ru.mirea.lab23.Evaluation2.operation.BinaryOperation;

public class CheckedAdd extends BinaryOperation {
    public CheckedAdd(TripleExpression left, TripleExpression right) {
        super(left, right);
    }

    protected int evaluate(int left, int right) {
        if (right > 0 ? left > Integer.MAX_VALUE - right
                : left < Integer.MIN_VALUE - right) {
            throw new ArithmeticParserException("Overflow exception: " + left + " + " + right);
        }
        return left + right;
    }
}
