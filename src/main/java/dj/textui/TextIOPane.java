package dj.textui;

import dj.core.IOPane;
import org.beryx.textio.IntInputReader;
import org.beryx.textio.TextIO;
import org.beryx.textio.TextIoFactory;
import org.beryx.textio.TextTerminal;

@SuppressWarnings("WeakerAccess")
public class TextIOPane implements IOPane {
    private TextTerminal terminal;
    private IntInputReader inputReader;

    public TextIOPane() {
        TextIO textIO = TextIoFactory.getTextIO();
        terminal = textIO.getTextTerminal();
        inputReader = textIO.newIntInputReader();
    }

    @Override
    public void println(String format, Object... args) {
        terminal.printf(format, args);
    }

    @Override
    public int readInt(String prompt, int min, int max) {
        return inputReader.withMinVal(min).withMaxVal(max).read(prompt);
    }
}
