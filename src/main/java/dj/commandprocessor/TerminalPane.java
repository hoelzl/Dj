package dj.commandprocessor;

public interface TerminalPane {
    void displayChoice(int choiceNumber, String choiceText);

    int readInt(String prompt, int min, int max);
}
