package ru.mfti.koltunov.dz19;

import java.util.*;

class Main {
    public static void main(String[] args) {
        WeakHashMap<String, AdviceCollection.Advice> advCol = new WeakHashMap<>();
        String str = new String("Мой руки");
        String str1 = new String("Мой руки");
        String str2 = new String("Мой ноги");
        AdviceCollection.Advice advice = new AdviceCollection.Advice(str);
        AdviceCollection.Advice advice1 = new AdviceCollection.Advice(str1);
        AdviceCollection.Advice advice2 = new AdviceCollection.Advice(str2);
        advCol.put(str, advice);
        advCol.put(str1, advice1);
        advCol.put(str2, advice2);
        System.out.println(advCol);
        str2 = null;
        advice2 = null;
        System.out.println(advCol);
    }
}


class AdviceCollection {
    private WeakHashMap<String, Advice> advCol = new WeakHashMap<>();

    void newAdvice(String str) {
        if (!advCol.containsKey(str)) {
            Advice adv = new Advice(str);
            advCol.put(str, adv);
            return;
        }
        advCol.get(str);
    }



    @Override
    public String toString() {
        return "AdviceCollection{" +
                "advCol=" + advCol +
                '}';
    }

    static class Advice {
        private final String text;

        Advice(String text) {
            this.text = text;
        }

        public String getText() {
            return text;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Advice advice = (Advice) o;
            return Objects.equals(text, advice.text);
        }

        @Override
        public int hashCode() {
            return Objects.hash(getText());
        }

        @Override
        public String toString() {
            return "Advice{" +
                    "text='" + text + '\'' +
                    '}';
        }
    }

}

/*
Существует класс Совет, состоящий из строки, и класс, описывающий коллекцию советов.
Гарантируйте, что не может существовать двух одинаковых советов.
Неиспользуемые никем советы хранить необязательно.
 */