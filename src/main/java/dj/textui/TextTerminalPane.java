package dj.textui;

import dj.commandprocessor.TerminalPane;
import org.beryx.textio.IntInputReader;
import org.beryx.textio.TextIO;
import org.beryx.textio.TextIoFactory;
import org.beryx.textio.TextTerminal;

@SuppressWarnings("WeakerAccess")
public class TextTerminalPane implements TerminalPane {
    private TextTerminal terminal;
    private IntInputReader inputReader;

    public TextTerminalPane() {
        TextIO textIO = TextIoFactory.getTextIO();
        terminal = textIO.getTextTerminal();
        inputReader = textIO.newIntInputReader();
    }

    @Override
    public void displayChoice(int choiceNumber, String choiceText) {
        terminal.printf("%d: %s\n", choiceNumber, choiceText);
    }

    @Override
    public int readInt(String prompt, int min, int max) {
        return inputReader.withMinVal(min).withMaxVal(max).read(prompt);
    }
}
