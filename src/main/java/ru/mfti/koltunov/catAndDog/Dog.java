package ru.mfti.koltunov.catAndDog;

public class Dog implements Barking {
    private String name;

    public Dog(String name) {
        this.name = name;
    }

    public void bark() {
        System.out.println(this.name + ": гав!");
    }

    @Override
    public String toString() {
        return "Собака: " + name;
    }
}
