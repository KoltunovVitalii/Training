package ru.mfti.koltunov.security;

class Start{
    public static void main(String[] args) {
        Security security = new Security();
        Human prepod = new Prepod("Prepod");
        prepod.visit(security);

    }
}

public class Security {
    void check(Human h) {
        System.out.println("acess denied");
    }

    void check(Pupil h){
        if (h.name == null){
            System.out.println("acess denied");
        }
        System.out.println("welcome");
    }

    void check(Prepod h) {
        System.out.println("welcome");
    }

}

class Human{
    String name;

    public Human(String name) {
        this.name = name;
    }

    void visit(Security security){
        security.check(this);
    }
}

class Pupil extends Human{
    public Pupil(String name) {
        super(name);
    }
    void visit(Security security){
        security.check(this);
    }
}

class Prepod extends Human{
    public Prepod(String name) {
        super(name);
    }
    void visit(Security security){
        security.check(this);
    }
}
