package dj.core;

public interface ValuedItem<Value> {
    Value getValue();

    default void setValue(Value newValue) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }
}
