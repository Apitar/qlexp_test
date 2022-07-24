package expression.computational_graph;

import static expression.computational_graph.OperatorType.*;

public class Operator {

    private OperatorType type;

    public String toQlExpressOperator() {
        if (NAGATIVE.equals(type)) {
            return "not";
        } else if (EQUALS.equals(type)) {
            return "==";
        } else if (AND.equals(type)) {
            return "&&";
        }
        assert false;
        return null;
    }

    public static Operator newOperator(OperatorType type) {
        Operator operator = new Operator();
        operator.type = type;
        return operator;
    }

    public OperatorType getType() {
        return type;
    }
}
