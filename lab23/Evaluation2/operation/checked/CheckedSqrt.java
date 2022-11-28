package ru.mirea.lab23.Evaluation2.operation.checked;

import ru.mirea.lab23.Evaluation2.exceptions.ArithmeticParserException;
import ru.mirea.lab23.Evaluation2.expression.TripleExpression;
import ru.mirea.lab23.Evaluation2.operation.UnaryOperation;

public class CheckedSqrt extends UnaryOperation {
    public CheckedSqrt(TripleExpression object) {
        super(object);
    }

    protected int evaluate(int x) {
        if (x < 0)
            throw new ArithmeticParserException("negative radicand: sqrt(" + x + ")");
        if (x == 0)
            return 0;
        int result = 1;
        boolean decreased = false;
        int nx;
        for (; ; ) {
            nx = (result + x / result) >> 1;
            if (result == nx || nx > result && decreased) {
                break;
            }
            decreased = nx < result;
            result = nx;
        }
        return result;
    }
}
