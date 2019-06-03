package dj.dialog;

import dj.core.Command;

@SuppressWarnings("WeakerAccess")
public class SelectDialogChoiceCommand implements Command {
    public SelectDialogChoiceCommand(DialogChoice activity) {
        this.choice = activity;
    }

    @Override
    public void execute() {
        choice.activate();
    }

    @Override
    public String describe() {
        return choice.getLabel();
    }

    private DialogChoice choice;
}
