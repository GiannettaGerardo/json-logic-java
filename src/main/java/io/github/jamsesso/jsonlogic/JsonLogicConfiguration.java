package io.github.jamsesso.jsonlogic;

import io.github.jamsesso.jsonlogic.evaluator.JsonLogicEvaluator;
import io.github.jamsesso.jsonlogic.evaluator.JsonLogicExpression;
import io.github.jamsesso.jsonlogic.evaluator.expressions.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class JsonLogicConfiguration
{
    private final Map<String, JsonLogicExpression> expressions;
    private final JsonLogicEvaluator evaluator;

    public JsonLogicConfiguration() {
        this(null);
    }

    public JsonLogicConfiguration(final List<JsonLogicExpression> newExpressions) {
        expressions = new HashMap<>();

        // Add default operations
        addOperation(MathExpression.ADD);
        addOperation(MathExpression.SUBTRACT);
        addOperation(MathExpression.MULTIPLY);
        addOperation(MathExpression.DIVIDE);
        addOperation(MathExpression.MODULO);
        addOperation(MathExpression.MIN);
        addOperation(MathExpression.MAX);
        addOperation(NumericComparisonExpression.GT);
        addOperation(NumericComparisonExpression.GTE);
        addOperation(NumericComparisonExpression.LT);
        addOperation(NumericComparisonExpression.LTE);
        addOperation(IfExpression.IF);
        addOperation(IfExpression.TERNARY);
        addOperation(EqualityExpression.INSTANCE);
        addOperation(InequalityExpression.INSTANCE);
        addOperation(StrictEqualityExpression.INSTANCE);
        addOperation(StrictInequalityExpression.INSTANCE);
        addOperation(NotExpression.SINGLE);
        addOperation(NotExpression.DOUBLE);
        addOperation(LogicExpression.AND);
        addOperation(LogicExpression.OR);
        addOperation(LogExpression.STDOUT);
        addOperation(MapExpression.INSTANCE);
        addOperation(FilterExpression.INSTANCE);
        addOperation(ReduceExpression.INSTANCE);
        addOperation(AllExpression.INSTANCE);
        addOperation(ArrayHasExpression.SOME);
        addOperation(ArrayHasExpression.NONE);
        addOperation(MergeExpression.INSTANCE);
        addOperation(InExpression.INSTANCE);
        addOperation(ConcatenateExpression.INSTANCE);
        addOperation(SubstringExpression.INSTANCE);
        addOperation(MissingExpression.ALL);
        addOperation(MissingExpression.SOME);

        // Add new operations
        if (newExpressions != null) {
            for (JsonLogicExpression expression : newExpressions) {
                addOperation(expression);
            }
        }

        evaluator = new JsonLogicEvaluator(expressions);
    }

    private void addOperation(JsonLogicExpression expression) {
        expressions.put(expression.key(), expression);
    }

    public JsonLogicEvaluator getEvaluator() {
        return evaluator;
    }
}
