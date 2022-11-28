package ru.mirea.lab23.Evaluation2.operation.checked;

import ru.mirea.lab23.Evaluation2.exceptions.ArithmeticParserException;
import ru.mirea.lab23.Evaluation2.expression.TripleExpression;
import ru.mirea.lab23.Evaluation2.operation.BinaryOperation;

public class CheckedSubtract extends BinaryOperation {
    public CheckedSubtract(TripleExpression left, TripleExpression right) {
        super(left, right);
    }

    protected int evaluate(int left, int right) {
        if (right > 0 ? left < Integer.MIN_VALUE + right
                : left > Integer.MAX_VALUE + right) {
            throw new ArithmeticParserException("Integer overflow");
        }
        return left - right;
    }
}
