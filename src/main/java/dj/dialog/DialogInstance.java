package dj.dialog;

import java.util.List;

@SuppressWarnings("unused")
public class DialogInstance implements DialogActivity {
    private DialogManager dialogManager;
    private DialogText initialText;

    public DialogInstance(DialogManager dialogManager) {
        this.dialogManager = dialogManager;
    }

    public DialogInstance() {
    }

    public DialogManager getDialogManager() {
        return dialogManager;
    }

    public void setDialogManager(DialogManager dialogManager) {
        this.dialogManager = dialogManager;
    }

    public DialogText getInitialText() {
        return initialText;
    }

    public void setInitialText(DialogText initialText) {
        this.initialText = initialText;
    }

    @Override
    public void activate() {
        initialText.activate();
    }

    void proposeChoices(List<DialogChoice> choices) {
        dialogManager.proposeChoices(choices);
    }

    void selectChoice(DialogChoice choice) {
        dialogManager.selectChoice(choice);
    }
}
