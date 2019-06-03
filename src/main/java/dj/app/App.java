/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package dj.app;

import dj.commandprocessor.CommandSelector;
import dj.core.Command;
import dj.textui.TextCommandSelector;
import org.beryx.textio.TextIO;
import org.beryx.textio.TextIoFactory;
import org.beryx.textio.TextTerminal;

import java.util.ArrayList;
import java.util.List;

public class App {
    private TextTerminal terminal;
    private CommandSelector cs = new TextCommandSelector();
    private List<Command> commands = new ArrayList<>();

    App() {
        TextIO textIO = TextIoFactory.getTextIO();
        terminal = textIO.getTextTerminal();

        commands.add(new Command() {
            @Override
            public void execute() {
                terminal.printf("Executing first command\n");
            }

            @Override
            public String describe() {
                return "First command";
            }

        });
        commands.add(new Command() {
            @Override
            public void execute() {
                terminal.printf("Executing second command\n");
            }

            @Override
            public String describe() {
                return "Second command";
            }
        });
        commands.add(cs.getExitCommand());
    }

    public static void main(String[] args) {
        App app = new App();

        //noinspection StatementWithEmptyBody
        while (!app.cs.promptForAndExecuteSingleCommand(app.commands)) {
        }
        System.exit(0);
    }

    public String getDefaultName() {
        return "world";
    }
}
