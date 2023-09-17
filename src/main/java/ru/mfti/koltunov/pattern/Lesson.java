package ru.mfti.koltunov.pattern;

import ru.mfti.koltunov.catAndDog.Cat;
import ru.mfti.koltunov.catAndDog.CountingCat;
import ru.mfti.koltunov.catAndDog.WarningCat;

public class Lesson {
    public static void main(String[] args) {
        sumLengthes(()->"qwerty".length());
        sumLengthes(new MyString("qwerty"));

        Cat cat = new Cat();
        CountingCat countingCat = new CountingCat(cat);
        Cat.met(countingCat);
        System.out.println(countingCat.count);

        WarningCat warningCat = new WarningCat(cat);
        Cat.met(warningCat);

        CountingCat countingCat1 = new CountingCat(warningCat.cat);
        Cat.met(countingCat1);
        System.out.println(countingCat1.count);



    }

    public static double sumLengthes(Lengthable... lengthables) {
        double res = 0;
        for (Lengthable x : lengthables) {
            res += x.length();
        }
        return res;
    }
}

interface Lengthable {
    double length();
}

class MyString implements Lengthable { //обертка - адаптер
    String string;

    public MyString(String string) {
        this.string = string;
    }

    @Override
    public double length() {
        return string.length();
    }
}