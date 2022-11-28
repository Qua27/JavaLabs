package ru.mirea.lab23.Evaluation2.operation.checked;

import ru.mirea.lab23.Evaluation2.exceptions.ArithmeticParserException;
import ru.mirea.lab23.Evaluation2.expression.TripleExpression;
import ru.mirea.lab23.Evaluation2.operation.UnaryOperation;

public class CheckedNegate extends UnaryOperation {
    public CheckedNegate(TripleExpression object) {
        super(object);
    }

    protected int evaluate(int object) {
        if (object == Integer.MIN_VALUE)
            throw new ArithmeticParserException("Overflow exception: -(" + object + ")");
        return -object;
    }
}
