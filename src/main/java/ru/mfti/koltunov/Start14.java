package ru.mfti.koltunov;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Start14 {
    public static void main(String[] args) throws Exception {
        EHotness en= EHotness.valueOf("");
        en.m();
        System.out.println(en.getClass());
        System.out.println(en.getClass().getSuperclass());

    }

    public static void test(EHotness h1, EHotness h2) {
        System.out.println(h1 == h2);//true
    }

}

@AllArgsConstructor
@ToString
class Souce {
    String name;
    EHotness hotness;
}

@ToString
//остроты можно сравнить между собой - кто острее
//шаблоны объектно ориентированного программирования: multitone
// предзаполненный список острот
//NOT 0,  NORMAL 5,  HOT 10
//получать я их хочу по имени, без числа

enum EHotness implements Able{ //это класс реализует компарабл
    NOT(0){},NORMAL(5){},HOT(10){
        public void m(){
            System.out.println("HOT HOT HOT!!!!");
        }
    };//три константы, значение которых это объекты этого класса
    final int grade;

    EHotness(int grade) {
        this.grade = grade;
    }
    public void m(){
        System.out.println("it is a "+name());
    }

}
interface Able{
    void m();
}

class Hotness implements Comparable<Hotness> {
    public static final Hotness NOT = new Hotness(0, "NOT");
    public static final Hotness NORMAL = new Hotness(5, "NORMAL");
    public static final Hotness HOT = new Hotness(10, "HOT");
    private static List<Hotness> hots = new ArrayList<>();

    static {
        hots.add(NOT);
        hots.add(NORMAL);
        hots.add(HOT);
    }

    @Getter
    private int grade;//степень остроты в виде числа
    @Getter
    private String hotness;//степень остроты в виде строки

    private Hotness(int grade, String hotness) {
        this.grade = grade;
        this.hotness = hotness;
    }

    public static Hotness of(String hotness) {
        hotness = hotness.toUpperCase();
        for (Hotness h : hots) {
            if (h.hotness.equals(hotness)) {
                return h;
            }
        }
        throw new NoSuchElementException(hotness);
    }

    public int compareTo(Hotness other) {
        return grade - other.grade;
    }
}
/*
перечисления - зачем нужны, и как с ними работать
 */