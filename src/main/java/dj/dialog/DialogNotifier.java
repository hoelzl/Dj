package dj.dialog;

import dj.core.ValuedItem;

import java.util.ArrayList;
import java.util.List;

public class DialogNotifier {

    public DialogNotifier() {
        observers = new ArrayList<>();
    }

    public void register(DialogObserver observer) {
        observers.add(observer);
    }

    void display(ValuedItem<String> item) {
        if (item != null) {
            for (var observer : observers) {
                observer.onDisplay(item);
            }
        }
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

    private List<DialogObserver> observers;
}
