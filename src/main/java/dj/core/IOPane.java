package dj.core;

public interface IOPane {
    void println(String format, Object... args);

    default void println() {
        println("\n");
    }

    int readInt(String prompt, int min, int max);
}
