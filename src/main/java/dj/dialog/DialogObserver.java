package dj.dialog;

import dj.core.ValuedItem;

import java.util.List;

public interface DialogObserver {
    void onDisplay(ValuedItem<String> item);

    void onChoicesProposed(List<DialogChoice> proposedChoices);

    void onChoiceSelected(DialogChoice choice);
}
