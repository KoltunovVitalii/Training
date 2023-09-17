package ru.mfti.koltunov;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class KarateKid {

    public static void main(String[] args) {
        KarateKid karateKid = new KarateKid("V");
        Combo combo = new Combo();
        combo.list.add(x->x.jump());
        combo.list.add(x->x.jump());
        combo.list.add(x->x.kick());
        combo.perform(karateKid);
    }
    String name;
    public KarateKid(String name) {
        this.name = name;
    }
    public void kick() {
        System.out.println(name + ": KICK!");
    }
    public void punch() {
        System.out.println(name + ": BAM!!");
    }
    public void jump() {
        System.out.println(name + ": KIYAA!");
    }
}

class Combo {
    List<Action> list = new ArrayList<>();
    public void perform(KarateKid karateKid) {
        for (Action action:list) {
            action.make(karateKid);
        }
    }
}

interface Action {
    void make(KarateKid karateKid);
}
