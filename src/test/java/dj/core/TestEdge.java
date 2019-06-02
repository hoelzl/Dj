package dj.core;

class TestEdge extends AbstractEdge<TestNode, TestEdge> {
    TestEdge(TestNode startNode, TestNode endNode) {
        super(startNode, endNode);
    }

    TestEdge(String label) {
        super(label);
    }

    TestEdge() {
        super();
    }
}
