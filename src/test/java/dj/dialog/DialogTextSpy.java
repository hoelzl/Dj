package dj.dialog;

public class DialogTextSpy extends DialogText {
    boolean wasActivated = false;

    DialogTextSpy(DialogInstance dialogInstance, String label) {
        super(dialogInstance, label);
    }

    @Override
    public void activate() {
        wasActivated = true;
    }
}
