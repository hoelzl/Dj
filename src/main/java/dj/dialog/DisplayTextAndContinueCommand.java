package dj.dialog;

import dj.core.Command;

@SuppressWarnings("WeakerAccess")
public class DisplayTextAndContinueCommand implements Command {
    public DisplayTextAndContinueCommand(DialogText dialogText) {
        this.dialogText = dialogText;
    }

    @Override
    public void execute() {
        dialogText.activate();
    }

    @Override
    public String describe() {
        return dialogText.getLabel();
    }

    private DialogText dialogText;
}
