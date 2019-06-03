package dj.dialog;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class DialogManagerTest {
    private DialogObserverSpy spy1;
    private DialogObserverSpy spy2;
    private DialogManager unit;
    private DialogInstance dialogInstance;

    DialogManagerTest() {
        unit = new DialogManager();
        dialogInstance = new DialogInstance(unit);
        spy1 = new DialogObserverSpy();
        spy2 = new DialogObserverSpy();

        unit.register(spy1);
        unit.register(spy2);
    }

    @Test
    void proposeChoices_notifiesAllObservers() {
        DialogChoice choice1 = new DialogChoice(dialogInstance, "choice1");
        DialogChoice choice2 = new DialogChoice(dialogInstance, "choice2");
        List<DialogChoice> choices = Arrays.asList(choice1, choice2);

        unit.proposeChoices(choices);

        assertThat(spy1.proposedChoices, is(choices));
        assertThat(spy2.proposedChoices, is(choices));
    }

    @Test
    void selectChoice_notifiesAllObservers() {
        DialogChoice choice = new DialogChoice(dialogInstance, "choice1");

        unit.selectChoice(choice);

        assertThat(spy1.selectedChoice, is(choice));
        assertThat(spy2.selectedChoice, is(choice));
    }
}
