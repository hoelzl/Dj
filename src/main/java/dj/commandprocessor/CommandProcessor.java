package dj.commandprocessor;

import dj.core.Command;
import dj.core.CommandProvider;

import java.util.ArrayList;
import java.util.List;

public class CommandProcessor {
    public void updateAndProcessCommands() {
        updateCommands();
        notifyObservers();
    }

    private void updateCommands() {
        commands.clear();
        for (var commandProvider : commandProviders) {
            commands.addAll(commandProvider.provideCommands());
        }
    }

    private void notifyObservers() {
        for (var observer : observers) {
            observer.onCommandsAvailable(commands);
        }
    }

    public void addCommandProvide(CommandProvider newCommandProvider) {
        commandProviders.add(newCommandProvider);
    }

    public void removeCommandProvider(CommandProvider commandProvider) {
        commandProviders.remove(commandProvider);
    }

    public void clearCommandProviders() {
        commandProviders.clear();
    }

    private List<Command> commands = new ArrayList<>();
    private List<CommandProvider> commandProviders = new ArrayList<>();
    private List<CommandObserver> observers = new ArrayList<>();
}
