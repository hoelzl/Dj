package dj.dialog;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class DialogInstanceTest {
    DialogInstanceTest() {
        unit.setInitialText(initialText);
    }

    @Test
    void activate_callsActivateOfInitialText() {
        unit.activate();

        assertThat(initialText.wasActivated, is(true));
    }

    @Test
    void proposeChoices_callsProposeChoicesOfDialogManager() {
        DialogChoice choice1 = new DialogChoice(unit, "choice1");
        DialogChoice choice2 = new DialogChoice(unit, "choice2");
        List<DialogChoice> choices = Arrays.asList(choice1, choice2);

        unit.proposeChoices(choices);

        assertThat(dialogManager.proposedChoices, is(choices));
    }

    @Test
    void selectChoice_callsSelectChoiceOfDialogManager() {
        DialogChoice choice = new DialogChoice(unit, "choice1");

        unit.selectChoice(choice);

        assertThat(dialogManager.selectedChoice, is(choice));
    }

    private DialogManagerSpy dialogManager = new DialogManagerSpy();
    private DialogInstance unit = new DialogInstance(dialogManager);
    private DialogTextSpy initialText = new DialogTextSpy(unit, "start");
}