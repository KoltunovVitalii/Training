package ru.mfti.koltunov.catAndDog;

public class HouseCat implements Meowing{

    private String name;

    public HouseCat(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void meow() {
        System.out.println("МЯЯЯЯЯЯЯУУУУУУ");;
    }
}
