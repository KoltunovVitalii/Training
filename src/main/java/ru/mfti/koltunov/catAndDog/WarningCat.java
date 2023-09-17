package ru.mfti.koltunov.catAndDog;

public class WarningCat implements Meowing {
    public Cat cat;

    public WarningCat(Cat cat) {
        this.cat = cat;
    }

    public void meow() {
        System.out.print("WARNING!!! ");
        cat.meow();
    }
}
