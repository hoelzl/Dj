package dj.core;

public interface Edge<N extends Node<N, E>, E extends Edge<N, E>> extends LabeledItem {
    Node<N, E> getStartNode();

    default void setStartNode(Node<N, E> node) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    Node<N, E> getEndNode();

    default void setEndNode(Node<N, E> node) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    default boolean isGloballyDisabled() {
        return false;
    }

    @SuppressWarnings("unused")
    default boolean isEnabledFor(Object obj) {
        return !isGloballyDisabled();
    }
}
