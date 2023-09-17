package ru.mfti.koltunov.birds;

public class Cuckoo extends Birds {

    public Cuckoo() {
    }

    @Override
    public void song() {
        String song = "ку-ку";
        for (int i = 0; i < Math.random() * 10; i++) {
            System.out.println(song);
        }
    }
}
