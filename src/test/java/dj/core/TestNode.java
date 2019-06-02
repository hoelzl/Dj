package dj.core;

import java.util.List;

class TestNode extends AbstractNode<TestNode> {
    TestNode(List<Edge<TestNode>> incomingEdges, List<Edge<TestNode>> outgoingEdges) {
        super(incomingEdges, outgoingEdges);
    }

    TestNode() {
        super();
    }
}
