package dj.dialog;

import dj.core.AbstractNode;
import dj.core.ValuedItem;

import java.util.List;

public class DialogText extends AbstractNode<DialogText, DialogChoice>
        implements DialogActivity, ValuedItem<String> {

    public DialogText(DialogInstance dialogInstance, String label, String value,
                      List<DialogChoice> incomingEdges,
                      List<DialogChoice> outgoingEdges) {
        super(incomingEdges, outgoingEdges, label);
        this.dialogInstance = dialogInstance;
        this.value = value;
    }

    public DialogText(DialogInstance dialogInstance, String label,
                      List<DialogChoice> incomingEdges,
                      List<DialogChoice> outgoingEdges) {
        super(incomingEdges, outgoingEdges, label);
        this.dialogInstance = dialogInstance;
    }

    public DialogText(DialogInstance dialogInstance, String label,
                      String value) {
        super(label);
        this.dialogInstance = dialogInstance;
        this.value = value;
    }

    public DialogText(DialogInstance dialogInstance, String label) {
        super(label);
        this.dialogInstance = dialogInstance;
    }

    public List<DialogChoice> getChoices() {
        return getOutgoingEdges();
    }

    public void addChoice(DialogChoice choice)
            throws IllegalArgumentException, UnsupportedOperationException {
        if (choice.getStartNode() == null) {
            choice.setStartNode(this);
        } else if (choice.getStartNode() != this) {
            throw new IllegalArgumentException(
                    "Choice already belongs to different text");
        }
        var choices = getChoices();
        if (!choices.contains(choice)) {
            choices.add(choice);
        }
    }

    @Override
    public void activate() {
        dialogInstance.proposeChoices(getOutgoingEdges());
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public void setValue(String newValue) throws UnsupportedOperationException {
        value = newValue;
    }

    private DialogInstance dialogInstance;
    private String value;
}
