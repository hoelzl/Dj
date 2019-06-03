package dj.core;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertNull;

class AbstractEdgeTest {
    @Test
    void getStartNode_WhenEdgeHasValidStartAndEndNode() {
        TestEdge unit = new TestEdge(startNode, endNode);

        assertThat(unit.getStartNode(), is(startNode));
    }

    @Test
    void getStartNode_WhenEdgeHasNullStartAndEnd() {
        TestEdge unit = new TestEdge();

        assertNull(unit.getStartNode());
    }

    @Test
    void setStartNode_WhenEdgeHasNullStartAndEnd() {
        TestEdge unit = new TestEdge();
        unit.setStartNode(startNode);

        assertThat(unit.getStartNode(), is(startNode));
    }

    @Test
    void getEndNode_WhenEdgeHasValidStartAndEndNode() {
        TestEdge unit = new TestEdge(startNode, endNode);

        assertThat(unit.getEndNode(), is(endNode));
    }

    @Test
    void getEndNode_WhenEdgeHasNullStartAndEnd() {
        TestEdge unit = new TestEdge();

        assertNull(unit.getEndNode());
    }

    @Test
    void setEndNode_WhenEdgeHasNullStartAndEnd() {
        TestEdge unit = new TestEdge();
        unit.setEndNode(endNode);

        assertThat(unit.getEndNode(), is(endNode));
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

    @Test
    void isGloballyDisabled() {
        assertThat(new TestEdge().isGloballyDisabled(), is(false));
    }

    @Test
    void isEnabledFor() {
        final String aRandomValue = "Foo";
        assertThat(new TestEdge().isEnabledFor(aRandomValue), is(true));
    }

    private TestNode startNode = new TestNode();
    private TestNode endNode = new TestNode();
}
