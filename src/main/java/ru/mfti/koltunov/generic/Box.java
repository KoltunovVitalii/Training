package ru.mfti.koltunov.generic;

public class Box<T> {

    private T object;

    public Box() {
    }

    public Box(T object) {
        this.object = object;
    }

    public T getObject() {
        T t = this.object;
        this.object = null;
        return t;
    }

    public void setObject(T object) {
        if (!isEmpty()) {
            throw new RuntimeException("Коробка НЕ пуста");
        }
        this.object = object;
    }

    public boolean isEmpty() {
        return this.object == null;
    }

    @Override
    public String toString() {
        return "Box{" +
                "object=" + object +
                '}';
    }
}
