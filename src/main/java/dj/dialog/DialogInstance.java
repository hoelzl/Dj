package dj.dialog;

import dj.core.Command;
import dj.core.ValuedItem;

import java.util.List;

@SuppressWarnings("unused")
public class DialogInstance implements DialogActivity {
    public DialogInstance(DialogNotifier dialogNotifier) {
        this.dialogNotifier = dialogNotifier;
    }

    public DialogInstance() {
    }

    public DialogNotifier getDialogNotifier() {
        return dialogNotifier;
    }

    public void setDialogNotifier(DialogNotifier dialogNotifier) {
        this.dialogNotifier = dialogNotifier;
    }

    public DialogText getInitialText() {
        return initialText;
    }

    public void setInitialText(DialogText initialText) {
        this.initialText = initialText;
        this.activeDialogActivity = initialText;
    }

    @Override
    public void activate() {
        activeDialogActivity.activate();
    }

    void display(ValuedItem<String> item) {
        dialogNotifier.display(item);
    }

    void proposeChoices(List<DialogChoice> choices) {
        dialogNotifier.proposeChoices(choices);
    }

    void selectChoice(DialogChoice choice) {
        dialogNotifier.selectChoice(choice);
    }

    @Override
    public List<Command> provideCommands() {
        return activeDialogActivity.provideCommands();
    }

    private DialogNotifier dialogNotifier;
    private DialogText initialText;
    private DialogActivity activeDialogActivity;
}
