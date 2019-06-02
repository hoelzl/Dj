package dj.dialog;

import dj.core.AbstractEdge;
import dj.core.ValuedItem;

public class DialogChoice extends AbstractEdge<DialogText, DialogChoice>
        implements DialogActivity, ValuedItem<String> {

    private String value;
    private DialogManager dialogManager;

    public DialogChoice(DialogManager dialogManager, String label, DialogText startNode,
                        DialogText endNode) {
        super(startNode, endNode, label);
        this.dialogManager = dialogManager;
    }

    public DialogChoice(DialogManager dialogManager, String label) {
        super(label);
        this.dialogManager = dialogManager;
    }

    @Override
    public void activate() {
        dialogManager.selectChoice(this);
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
