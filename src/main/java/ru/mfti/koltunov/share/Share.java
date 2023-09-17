package ru.mfti.koltunov.share;

import java.util.LinkedList;
import java.util.List;

public class Share implements ObcervableToShare{
    private String name;
    private int price;
    List<Observer> observerList = new LinkedList<>();
    public Share(String name) {
        this(name, 0);
    }
    public Share(String name, int price) {
        this.name = name;
        this.price = price;
    }
    public String getName() {
        return name;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
        notification();
    }
    @Override
    public String toString() {
        return name + ": " + price;
    }
    @Override
    public void subscription(Observer observer) {
        observerList.add(observer);
    }
    @Override
    public void remove(Observer observer) {
        observerList.remove(observer);
    }
    @Override
    public void notification() {
        for (Observer observer : observerList) {
            observer.update(name, price);
        }
    }
}
