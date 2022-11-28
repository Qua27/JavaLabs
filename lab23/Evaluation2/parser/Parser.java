package ru.mirea.lab23.Evaluation2.parser;

import ru.mirea.lab23.Evaluation2.exceptions.FormatParserException;
import ru.mirea.lab23.Evaluation2.expression.TripleExpression;

public interface Parser {
    TripleExpression parse(String expression) throws FormatParserException;
}
