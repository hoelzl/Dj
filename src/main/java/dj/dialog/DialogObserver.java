package dj.dialog;

import java.util.List;

public interface DialogObserver {
    void onChoicesProposed(List<DialogChoice> proposedChoices);

    void onChoiceSelected(DialogChoice choice);
}
