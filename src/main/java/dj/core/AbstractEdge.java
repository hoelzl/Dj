package dj.core;

@SuppressWarnings("WeakerAccess")
public abstract class AbstractEdge<NodeSelf extends Node<NodeSelf>> implements Edge<NodeSelf> {
    private Node<NodeSelf> startNode;
    private Node<NodeSelf> endNode;
    private String label;

    public AbstractEdge(NodeSelf startNode, NodeSelf endNode, String label) {
        this.startNode = startNode;
        this.endNode = endNode;
        this.label = label;
    }

    public AbstractEdge(NodeSelf startNode, NodeSelf endNode) {
        this(startNode, endNode, "");
    }

    public AbstractEdge(String label) {
        this(null, null, label);
    }

    public AbstractEdge() {
        this(null, null);
    }

    @Override
    public Node<NodeSelf> getStartNode() {
        return startNode;
    }

    @Override
    public void setStartNode(Node<NodeSelf> node) throws UnsupportedOperationException {
        startNode = node;
    }

    @Override
    public Node<NodeSelf> getEndNode() {
        return endNode;
    }

    @Override
    public void setEndNode(Node<NodeSelf> node) throws UnsupportedOperationException {
        endNode = node;
    }

    @Override
    public String getLabel() {
        return label;
    }
}
