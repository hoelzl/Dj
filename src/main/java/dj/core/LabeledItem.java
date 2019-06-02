package dj.core;

public interface LabeledItem {
    default String getLabel() {
        return "";
    }
}
