package dj.textui;

import dj.commandprocessor.CommandSelector;

public class TextCommandSelector extends CommandSelector {
    public TextCommandSelector() {
        super(new TextTerminalPane());
    }
}
