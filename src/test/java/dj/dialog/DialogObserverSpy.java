package dj.dialog;

import java.util.List;

public class DialogObserverSpy implements DialogObserver {
    @Override
    public void onChoicesProposed(List<DialogChoice> proposedChoices) {
        this.proposedChoices = proposedChoices;
    }

    @Override
    public void onChoiceSelected(DialogChoice choice) {
        this.selectedChoice = choice;
    }

    List<DialogChoice> proposedChoices;
    DialogChoice selectedChoice;
}
