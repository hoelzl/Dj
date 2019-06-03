package dj.dialog;

public class DialogTextSpy extends DialogText {
    DialogTextSpy(DialogInstance dialogInstance, String label) {
        super(dialogInstance, label);
    }

    @Override
    public void activate() {
        wasActivated = true;
    }

    boolean wasActivated = false;
}
