package dj.commandprocessor;

import dj.core.Command;

import java.util.List;

@SuppressWarnings("WeakerAccess")
public class CommandSelector {
    public CommandSelector(TerminalPane terminalPane) {
        this.terminalPane = terminalPane;
    }

    public Command getExitCommand() {
        return exitCommand;
    }

    public boolean promptForAndExecuteSingleCommand(List<Command> commands) {
        Command command = promptForCommand(commands);
        command.execute();
        return shouldExit;
    }

    public Command promptForCommand(List<Command> commands) {

        for (int i = 0; i < commands.size(); i++) {
            Command c = commands.get(i);
            terminalPane.displayChoice(i + 1, c.describe());
        }
        int selectedCommand =
                terminalPane.readInt("Select a command:", 1, commands.size());
        return commands.get(selectedCommand - 1);
    }

    private TerminalPane terminalPane;
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
}
