package dj.core;

import java.util.List;

public interface Node<N extends Node<N, E>, E extends Edge<N, E>>
        extends LabeledItem {
    List<E> getIncomingEdges();

    List<E> getOutgoingEdges();
}
