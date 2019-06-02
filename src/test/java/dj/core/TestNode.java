package dj.core;

import java.util.List;

class TestNode extends AbstractNode<TestNode, TestEdge> {
    TestNode(List<TestEdge> incomingEdges, List<TestEdge> outgoingEdges) {
        super(incomingEdges, outgoingEdges);
    }

    TestNode() {
        super();
    }
}
