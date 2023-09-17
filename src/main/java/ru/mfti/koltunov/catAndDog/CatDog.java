package ru.mfti.koltunov.catAndDog;

public class CatDog implements Meowing, Barking {
    Meowing meowing;
    Barking barking;

    public CatDog(String name) {
        this.meowing = new Cat(name);
        this.barking = new Dog(name);
    }

    public Barking getBarking() {
        return barking;
    }

    @Override
    public void bark() {
        barking.bark();
    }

    @Override
    public void meow() {
        meowing.meow();
    }
}
