package io.github.jamsesso.jsonlogic;

import io.github.jamsesso.jsonlogic.ast.JsonLogicNode;
import io.github.jamsesso.jsonlogic.evaluator.JsonLogicEvaluator;

public final class JsonLogicWorker
{
    private final JsonLogicEvaluator evaluator;

    public JsonLogicWorker(final JsonLogicConfiguration configuration) {
        assert configuration != null;
        evaluator = configuration.getEvaluator();
    }

    public Object evaluate(JsonLogicNode node, Object data) throws JsonLogicException {
        return evaluator.evaluate(node, data);
    }
}

