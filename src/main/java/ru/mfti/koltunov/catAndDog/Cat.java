package ru.mfti.koltunov.catAndDog;

public class Cat implements Meowing{
    private String name;

    public Cat() {
    }

    public Cat(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Кот: " + name;
    }

    public static void met(Meowing meowing){
        meowing.meow();
    }



    public void meow() {
        System.out.println("мяу");
    }

    public void meow(int x) {
        String meow = "";
        for (int i = 0; i < x-1; i++) {
            meow = meow + "мяу-";
        }
        meow = meow + "мяу!";
        System.out.println(meow);
    }
}

