package dj.commandprocessor;

import dj.core.Command;

import java.util.List;

public interface CommandObserver {
    void onCommandsAvailable(List<Command> command);
}
