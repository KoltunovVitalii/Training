package ru.mfti.koltunov.catAndDog;

public class CountingCat implements Meowing {
    Cat cat;
    public int count;

    public CountingCat(Cat cat) {
        this.cat = cat;
    }

    public void meow() {
        count++;
        cat.meow();
    }
}
