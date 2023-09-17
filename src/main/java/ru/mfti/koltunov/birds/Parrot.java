package ru.mfti.koltunov.birds;

public class Parrot extends Birds {


    String s;

    public Parrot(String s) {
        this.s = s;
    }

    @Override
    public void song() {
        char[] chArr = s.toCharArray();
        int x = (int) (Math.random() * 10);
        int y = (int) (Math.random() * 10);
        int countMix = (int) (Math.random() * 10);
        for (int i = 0; i < countMix + 1; i++) {
            if (x < chArr.length && y < chArr.length) {
                char c = chArr[x];
                chArr[x] = chArr[y];
                chArr[y] = c;
            }
        }
        String result = new String(chArr);
        System.out.println(result);
    }
}
