package dj.core;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("WeakerAccess")
public abstract class AbstractNode<Self extends AbstractNode<Self>> implements Node<Self> {

    private List<Edge<Self>> incomingEdges;
    private List<Edge<Self>> outgoingEdges;
    private String label;

    public AbstractNode(List<Edge<Self>> incomingEdges, List<Edge<Self>> outgoingEdges,
                        String label) {
        this.incomingEdges = incomingEdges;
        this.outgoingEdges = outgoingEdges;
        this.label = label;

        try {
            for (Edge<Self> edge : incomingEdges) {
                edge.setEndNode(this);
            }
            for (Edge<Self> edge : outgoingEdges) {
                edge.setStartNode(this);
            }
        } catch (UnsupportedOperationException ex) {
            throw new UnsupportedOperationException(
                    "Cannot build abstract node from existing edges.", ex);
        }
    }

    public AbstractNode(List<Edge<Self>> incomingEdges, List<Edge<Self>> outgoingEdges) {

        this(incomingEdges, outgoingEdges, "");
    }

    public AbstractNode(String label) {
        this(new ArrayList<>(), new ArrayList<>(), label);
    }

    public AbstractNode() {
        this(new ArrayList<>(), new ArrayList<>());
    }

    @Override
    public List<Edge<Self>> getIncomingEdges() {
        return incomingEdges;
    }

    @Override
    public List<Edge<Self>> getOutgoingEdges() {
        return outgoingEdges;
    }

    @Override
    public String getLabel() {
        return label;
    }
}
