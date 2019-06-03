package dj.commandprocessor;

import dj.core.Command;
import dj.core.IOPane;

import java.util.List;

@SuppressWarnings("WeakerAccess")
public class CommandSelector {
    private IOPane ioPane;
    private boolean shouldExit = false;

    private Command exitCommand = new Command() {
        @Override
        public void execute() {
            shouldExit = true;
        }

        @Override
        public String describe() {
            return "Exit";
        }
    };

    public CommandSelector(IOPane ioPane) {
        this.ioPane = ioPane;
    }

    public Command getExitCommand() {
        return exitCommand;
    }

    public boolean promptForAndExecuteSingleCommand(List<Command> commands) {
        Command command = promptForCommand(commands);
        command.execute();
        ioPane.println();

        return shouldExit;
    }

    public Command promptForCommand(List<Command> commands) {

        for (int i = 0; i < commands.size(); i++) {
            Command c = commands.get(i);
            ioPane.println("%d: %s\n", i + 1, c.describe());
        }
        int selectedCommand = ioPane.readInt("Select a command:", 1, commands.size());
        return commands.get(selectedCommand - 1);
    }
}
