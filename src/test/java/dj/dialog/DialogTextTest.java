package dj.dialog;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DialogTextTest {
    private DialogManagerSpy dialogManager = new DialogManagerSpy();

    @Test
    void addChoice_whenNewChoiceIsNotPresentAndValid_AddsNewChoiceToChoices() {
        DialogText unit = new DialogText(dialogManager, "unit");
        DialogChoice choice1 = new DialogChoice(dialogManager, "choice1");
        DialogChoice choice2 = new DialogChoice(dialogManager, "choice2", unit, null);
        unit.addChoice(choice1);
        unit.addChoice(choice2);

        assertThat(unit.getChoices(), hasSize(2));
        assertThat(unit.getChoices(), contains(choice1, choice2));
        assertThat(choice1.getStartNode(), is(unit));
        assertThat(choice2.getStartNode(), is(unit));
    }

    @Test
    void addChoice_throwsWhenChoiceHasOtherStartNode() {
        DialogText unit = new DialogText(dialogManager, "unit");
        DialogText otherText = new DialogText(dialogManager, "other");
        DialogChoice choice = new DialogChoice(dialogManager, "choice", otherText, null);

        assertThrows(IllegalArgumentException.class, () -> unit.addChoice(choice));
    }

    @Test
    void activate_proposesChoiceToDialogManager() {
        DialogText unit = new DialogText(dialogManager, "unit");
        DialogChoice choice1 = new DialogChoice(dialogManager, "choice1");
        DialogChoice choice2 = new DialogChoice(dialogManager, "choice2");
        unit.addChoice(choice1);
        unit.addChoice(choice2);

        unit.activate();

        assertThat(dialogManager.proposedChoices, hasSize(2));
        assertThat(dialogManager.proposedChoices, contains(choice1, choice2));
    }

    @Test
    void constructor_assignsLabelAndValueCorrectly() {
        DialogText unit = new DialogText(dialogManager, "label", "value");

        assertThat(unit.getLabel(), is("label"));
        assertThat(unit.getValue(), is("value"));
    }

    @Test
    void setValue() {
        DialogText unit = new DialogText(dialogManager, "label");

        unit.setValue("new value");

        assertThat(unit.getValue(), is("new value"));
    }

}