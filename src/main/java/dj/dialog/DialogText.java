package dj.dialog;

import dj.core.AbstractNode;
import dj.core.ValuedItem;

import java.util.List;

public class DialogText extends AbstractNode<DialogText, DialogChoice>
        implements DialogActivity, ValuedItem<String> {

    private DialogManager dialogManager;
    private String value;

    public DialogText(DialogManager dialogManager, String label, String value,
                      List<DialogChoice> incomingEdges, List<DialogChoice> outgoingEdges) {
        super(incomingEdges, outgoingEdges, label);
        this.dialogManager = dialogManager;
        this.value = value;
    }

    public DialogText(DialogManager dialogManager, String label, List<DialogChoice> incomingEdges,
                      List<DialogChoice> outgoingEdges) {
        super(incomingEdges, outgoingEdges, label);
        this.dialogManager = dialogManager;
    }

    public DialogText(DialogManager dialogManager, String label, String value) {
        super(label);
        this.dialogManager = dialogManager;
        this.value = value;
    }

    public DialogText(DialogManager dialogManager, String label) {
        super(label);
        this.dialogManager = dialogManager;
    }

    public List<DialogChoice> getChoices() {
        return getOutgoingEdges();
    }

    public void addChoice(DialogChoice choice)
            throws IllegalArgumentException, UnsupportedOperationException {
        if (choice.getStartNode() == null) {
            choice.setStartNode(this);
        } else if (choice.getStartNode() != this) {
            throw new IllegalArgumentException("Choice already belongs to different text");
        }
        var choices = getChoices();
        if (!choices.contains(choice)) {
            choices.add(choice);
        }
    }

    @Override
    public void activate() {
        dialogManager.proposeChoices(getOutgoingEdges());
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public void setValue(String newValue) throws UnsupportedOperationException {
        value = newValue;
    }
}
