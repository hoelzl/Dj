package dj.core;


import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class AbstractNodeTest {
    private List<Edge<TestNode>> incomingEdges = Collections.singletonList(new TestEdge());
    private List<Edge<TestNode>> outgoingEdges = Collections.singletonList(new TestEdge());

    @Test
    void getIncomingEdges_ReturnsEmptyList_WhenDefaultConstructed() {
        TestNode unit = new TestNode();

        assertThat(unit.getIncomingEdges().isEmpty(), is(true));
    }

    @Test
    void constructor_AssignsEndNode() {
        TestNode unit = new TestNode(incomingEdges, outgoingEdges);

        assertThat(unit.getIncomingEdges().get(0).getEndNode(), is(unit));
    }

    @Test
    void getOutgoingEdges_ReturnsEmptyList_WhenDefaultConstructed() {
        TestNode unit = new TestNode();

        assertThat(unit.getOutgoingEdges().isEmpty(), is(true));
    }

    @Test
    void constructor_AssignsStartNode() {
        TestNode unit = new TestNode(incomingEdges, outgoingEdges);

        assertThat(unit.getOutgoingEdges().get(0).getStartNode(), is(unit));
    }

    @Test
    void getLabel_ReturnsProvidedLabel_WhenLabelWasProvided() {
        final String randomLabel = "labeled";

        TestEdge unit = new TestEdge(randomLabel);

        assertThat(unit.getLabel(), is(randomLabel));
    }

    @Test
    void getLabel_ReturnsEmptyString_WhenNoLabelWasProvided() {
        TestEdge unit = new TestEdge();

        assertThat(unit.getLabel(), is(""));
    }
}