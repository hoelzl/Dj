package dj.core;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractNode<N extends AbstractNode<N, E>, E extends Edge<N, E>>
        implements Node<N, E> {

    public AbstractNode(List<E> incomingEdges, List<E> outgoingEdges,
                        String label) {
        this.incomingEdges = incomingEdges;
        this.outgoingEdges = outgoingEdges;
        this.label = label;

        try {
            for (E edge : incomingEdges) {
                edge.setEndNode(this);
            }
            for (E edge : outgoingEdges) {
                edge.setStartNode(this);
            }
        } catch (UnsupportedOperationException ex) {
            throw new UnsupportedOperationException(
                    "Cannot build abstract node from existing edges.", ex);
        }
    }
    public AbstractNode(List<E> incomingEdges, List<E> outgoingEdges) {

        this(incomingEdges, outgoingEdges, "");
    }
    public AbstractNode(String label) {
        this(new ArrayList<>(), new ArrayList<>(), label);
    }

    public AbstractNode() {
        this(new ArrayList<>(), new ArrayList<>());
    }

    @Override
    public List<E> getIncomingEdges() {
        return incomingEdges;
    }

    @Override
    public List<E> getOutgoingEdges() {
        return outgoingEdges;
    }

    @Override
    public String getLabel() {
        return label;
    }

    private List<E> incomingEdges;
    private List<E> outgoingEdges;
    private String label;
}
