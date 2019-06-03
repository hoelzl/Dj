package dj.dialog;

import dj.core.AbstractEdge;
import dj.core.Command;
import dj.core.CommandProvider;
import dj.core.ValuedItem;

import java.util.Collections;
import java.util.List;

public class DialogChoice extends AbstractEdge<DialogText, DialogChoice>
        implements DialogActivity, ValuedItem<String>, CommandProvider {

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

    private String value;
    private DialogManager dialogManager;

    @Override
    public List<Command> provideCommands() {
        return Collections.singletonList(new SelectDialogChoiceCommand(this));
    }
}
