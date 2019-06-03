package dj.dialog;

import java.util.List;

class DialogManagerSpy extends DialogManager {
    @Override
    void proposeChoices(List<DialogChoice> choices) {
        proposedChoices = choices;
    }

    @Override
    void selectChoice(DialogChoice choice) {
        selectedChoice = choice;
    }

    List<DialogChoice> proposedChoices;
    DialogChoice selectedChoice;
}
