package dj.textui;

import dj.core.Command;
import org.beryx.textio.TextIO;
import org.beryx.textio.TextIoFactory;
import org.beryx.textio.TextTerminal;

import java.util.List;

@SuppressWarnings("WeakerAccess")
public class CommandSelector {
    private TextIO textIO = TextIoFactory.getTextIO();
    private boolean shouldExit = false;
    public Command exitCommand = new Command() {
        @Override
        public void execute() {
            shouldExit = true;
        }

        @Override
        public String describe() {
            return "Exit";
        }
    };

    public boolean promptForAndExecuteSingleCommand(List<Command> commands) {
        TextTerminal terminal = textIO.getTextTerminal();
        CommandSelector cs = new CommandSelector();
        Command command = cs.promptForCommand(commands);
        command.execute();
        terminal.println();

        return shouldExit;
    }

    public Command promptForCommand(List<Command> commands) {
        TextTerminal terminal = textIO.getTextTerminal();
        for (int i = 0; i < commands.size(); i++) {
            Command c = commands.get(i);
            terminal.printf("%d: %s\n", i + 1, c.describe());
        }
        int selectedCommand = textIO.newIntInputReader()
                .withMinVal(1)
                .withMaxVal(commands.size())
                .read("Select a command:");
        return commands.get(selectedCommand - 1);
    }
}
