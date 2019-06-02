package dj.dialog;

import java.util.ArrayList;
import java.util.List;

public class DialogManager {
    private List<DialogObserver> observers;

    public DialogManager() {
        observers = new ArrayList<>();
    }

    void register(DialogObserver observer) {
        observers.add(observer);
    }

    void proposeChoices(List<DialogChoice> choices) {
        for (var observer : observers) {
            observer.onChoicesProposed(choices);
        }
    }

    void selectChoice(DialogChoice choice) {
        for (var observer : observers) {
            observer.onChoiceSelected(choice);
        }
    }
}
