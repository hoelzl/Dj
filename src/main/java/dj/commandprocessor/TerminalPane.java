package dj.commandprocessor;

public interface TerminalPane {
    void displayChoice(int choiceNumber, String choiceText);

    void displayText(String text);

    int readInt(String prompt, int min, int max);
}
