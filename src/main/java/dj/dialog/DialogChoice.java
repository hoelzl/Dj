package dj.dialog;

import dj.core.AbstractEdge;
import dj.core.Command;
import dj.core.CommandProvider;
import dj.core.ValuedItem;

import java.util.Collections;
import java.util.List;

public class DialogChoice extends AbstractEdge<DialogText, DialogChoice>
        implements DialogActivity, ValuedItem<String>, CommandProvider {

    public DialogChoice(DialogInstance dialogInstance, String label,
                        DialogText startNode, DialogText endNode) {
        super(startNode, endNode, label);
        this.dialogInstance = dialogInstance;
    }

    public DialogChoice(DialogInstance dialogInstance, String label) {
        super(label);
        this.dialogInstance = dialogInstance;
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public void setValue(String newValue) throws UnsupportedOperationException {
        value = newValue;
    }

    @Override
    public void activate() {
        dialogInstance.selectChoice(this);
    }

    @Override
    public List<Command> provideCommands() {
        return Collections.singletonList(new SelectDialogChoiceCommand(this));
    }

    private DialogInstance dialogInstance;
    private String value;
}
