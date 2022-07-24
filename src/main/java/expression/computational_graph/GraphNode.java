package expression.computational_graph;

import static expression.computational_graph.Constant.*;
import static expression.computational_graph.OperatorType.*;
import static expression.computational_graph.ValueType.*;

public class GraphNode {

    private GraphNode leftOperand;

    private GraphNode rightOperand;

    private Operator operator;

    private ValueType valueType;

    private Object value;

    /**
     * 新增初始节点
     * @param valueType 值类型
     * @param value 初始节点存储的值
     * @return 初始节点
     */
    public static GraphNode newInitNode(ValueType valueType, Object value) {
        GraphNode graphNode = new GraphNode();
        graphNode.valueType = valueType;
        graphNode.value = value;
        return graphNode;
    }

    /**
     * 新增运算节点
     * @param leftOperand 左操作数
     * @param rightOperand 右操作数
     * @param operator 运算符
     * @return 运算节点
     */
    public static GraphNode newComputationalNode(GraphNode leftOperand, GraphNode rightOperand, Operator operator) {
        GraphNode graphNode = new GraphNode();
        graphNode.leftOperand = leftOperand;
        graphNode.rightOperand = rightOperand;
        graphNode.operator = operator;
        return graphNode;
    }

    public String toQlExpression() {

        assert isInitNode() || isComputationalNode();

        if (isInitNode()) {
            return convertToValue(valueType, value);
        }

        if (NAGATIVE.equals(operator.getType())) {
            return LEFT_BRACKET + "not" + SPACE + leftOperand.toQlExpression() + RIGHT_BRACKET;
        }
        return LEFT_BRACKET + leftOperand.toQlExpression() + SPACE + operator.toQlExpressOperator() + SPACE +
                rightOperand.toQlExpression() + RIGHT_BRACKET;
    }

    private boolean isInitNode() {
        return null == leftOperand && null == rightOperand && null == operator && null != value;
    }

    private boolean isComputationalNode() {
        return null != leftOperand && null != operator && null == value;
    }

    private String convertToValue(ValueType resultType, Object resultValue) {
        if (BOOL.equals(resultType)) {
            return String.valueOf((boolean) resultValue);
        } else if (STRING.equals(resultType)) {
            return "\"" + resultValue + "\"";
        } else if (INT.equals(resultType)) {
            return String.valueOf((int) resultValue);
        } else if (ATTRIBUTE.equals(resultType)) {
            return (String) resultValue;
        }
        assert false;
        return null;
    }
}
