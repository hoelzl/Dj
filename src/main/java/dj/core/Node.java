package dj.core;

import java.util.List;

public interface Node<Self extends Node<Self>> extends LabeledItem {
    List<Edge<Self>> getIncomingEdges();

    List<Edge<Self>> getOutgoingEdges();
}
