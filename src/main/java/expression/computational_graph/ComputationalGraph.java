package expression.computational_graph;

public class ComputationalGraph {

    private GraphNode finalNode;

    public String toQlExpression() {
        return finalNode.toQlExpression();
    }

    public static void main(String[] args) {
        GraphNode initNode1 = GraphNode.newInitNode(ValueType.BOOL, false);
        GraphNode initNode2 = GraphNode.newInitNode(ValueType.STRING, "composite.currentStatus");
        GraphNode computationalNode1 = GraphNode.newComputationalNode(initNode1, initNode2,
                Operator.newOperator(OperatorType.EQUALS));

        GraphNode initNode3 = GraphNode.newInitNode(ValueType.BOOL, true);
        GraphNode computationalNode2 = GraphNode.newComputationalNode(initNode3, null,
                Operator.newOperator(OperatorType.NAGATIVE));

        GraphNode computationalNode3 = GraphNode.newComputationalNode(computationalNode1, computationalNode2,
                Operator.newOperator(OperatorType.AND));

        System.out.println(computationalNode3.toQlExpression());
    }
}
