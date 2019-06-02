package dj.core;

public interface Edge<NodeSelf extends Node<NodeSelf>> extends LabeledItem {
    Node<NodeSelf> getStartNode();

    default void setStartNode(Node<NodeSelf> node) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    Node<NodeSelf> getEndNode();

    default void setEndNode(Node<NodeSelf> node) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    default boolean isGloballyDisabled() {
        return false;
    }

    default boolean isEnabledFor(Object obj) {
        return !isGloballyDisabled();
    }
}
