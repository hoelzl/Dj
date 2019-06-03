package dj.dialog;

import java.util.List;

class DialogManagerSpy extends DialogManager {
    List<DialogChoice> proposedChoices;
    DialogChoice selectedChoice;

    @Override
    void proposeChoices(List<DialogChoice> choices) {
        proposedChoices = choices;
    }

    @Override
    void selectChoice(DialogChoice choice) {
        selectedChoice = choice;
    }
}
