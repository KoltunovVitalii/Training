package ru.mfti.koltunov;

//public class TrafficLight {
//    Color off = BlackColor.BLACK;
//    Color cur = off;
//
//
//    public void on() {
//        cur = RedColor.RED;
//    }
//
//    public void off() {
//        cur = off;
//    }
//
//    public void next() {
//        cur = cur.next();
//        System.out.println(cur);
//    }
//}
//
//class RedColor implements Color {
//    public static final Color RED = new RedColor();
//
//    private RedColor() {
//    }
//
//    @Override
//    public ru.mfti.koltunov.spring.Color next() {
//        return GreenColor.GREEN;
//    }
//
//    @Override
//    public String toString() {
//        return "Red";
//    }
//}
//
//class GreenColor implements Color {
//    public static final Color GREEN = new GreenColor();
//
//    private GreenColor() {
//    }
//
//    @Override
//    public ru.mfti.koltunov.spring.Color next() {
//        return RedColor.RED;
//    }
//
//    @Override
//    public String toString() {
//        return "Green";
//    }
//}
//
//class BlackColor implements Color {
//    public static final Color BLACK = new BlackColor();
//    int count = 0;
//
//    private BlackColor() {
//    }
//
//    @Override
//    public ru.mfti.koltunov.spring.Color next() {
//        count++;
//        if (count > 5) {
//            count = 0;
//            return RedColor.RED;
//        }
//        return this;
//    }
//
//    @Override
//    public String toString() {
//        return "Black";
//    }
//}
//
//public interface Color{
//    ru.mfti.koltunov.spring.Color next();
//};
