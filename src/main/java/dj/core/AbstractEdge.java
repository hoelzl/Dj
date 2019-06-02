package dj.core;

public abstract class AbstractEdge<N extends Node<N, E>, E extends Edge<N, E>>
        implements Edge<N, E> {
    private Node<N, E> startNode;
    private Node<N, E> endNode;
    private String label;

    public AbstractEdge(N startNode, N endNode, String label) {
        this.startNode = startNode;
        this.endNode = endNode;
        this.label = label;
    }

    public AbstractEdge(N startNode, N endNode) {
        this(startNode, endNode, "");
    }

    public AbstractEdge(String label) {
        this(null, null, label);
    }

    public AbstractEdge() {
        this(null, null);
    }

    @Override
    public Node<N, E> getStartNode() {
        return startNode;
    }

    @Override
    public void setStartNode(Node<N, E> node) throws UnsupportedOperationException {
        startNode = node;
    }

    @Override
    public Node<N, E> getEndNode() {
        return endNode;
    }

    @Override
    public void setEndNode(Node<N, E> node) throws UnsupportedOperationException {
        endNode = node;
    }

    @Override
    public String getLabel() {
        return label;
    }
}
