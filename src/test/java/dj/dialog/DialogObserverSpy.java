package dj.dialog;

import dj.core.ValuedItem;

import java.util.List;

@SuppressWarnings("WeakerAccess")
public class DialogObserverSpy implements DialogObserver {
    @Override
    public void onDisplay(ValuedItem<String> activity) {
        this.displayedItem = activity;
    }

    @Override
    public void onChoicesProposed(List<DialogChoice> proposedChoices) {
        this.proposedChoices = proposedChoices;
    }

    @Override
    public void onChoiceSelected(DialogChoice choice) {
        this.selectedChoice = choice;
    }

    ValuedItem<String> displayedItem;
    List<DialogChoice> proposedChoices;
    DialogChoice selectedChoice;
}
