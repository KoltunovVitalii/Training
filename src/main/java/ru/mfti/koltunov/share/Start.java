package ru.mfti.koltunov.share;

public class Start {
    public static void main(String[] args) {
        Share ORCL = new Share("ORCL", 75);
        Share TSLA = new Share("TSLA", 696);

        Observer o1 = (name, price) -> System.out.println(name + ": " + price);
        Observer o2 = (name, price) -> {
            if (price < 70) {
                System.out.println("надо покупать ORCL");
            }
        };

        ORCL.subscription(o1);
        ORCL.subscription(o2);

        TSLA.subscription(o1);

        ORCL.setPrice(60);
        TSLA.setPrice(454);



        }
    }
