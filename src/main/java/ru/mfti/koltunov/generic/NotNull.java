package ru.mfti.koltunov.generic;

public class NotNull<T> {
    private T object;

    public NotNull(T object) {
        this.object = object;
    }

    public T getObject(T t) {
        if (object == null) {
            return t;
        }
        return object;
    }

    @Override
    public String toString() {
        return "NotNull{" +
                "object=" + object +
                '}';
    }
}
