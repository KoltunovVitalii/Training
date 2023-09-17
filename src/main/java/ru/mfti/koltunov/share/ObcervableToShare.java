package ru.mfti.koltunov.share;

public interface ObcervableToShare {
    void subscription(Observer observer);
    void remove(Observer observer);
    void notification();
}
