package dj.core;

public interface Command {
    void execute();

    String describe();
}
