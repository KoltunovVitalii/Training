package ru.mfti.koltunov.figures;

public class Rectangle extends Figures{

    int sideLength1;
    int sideLength2;

    public Rectangle(Point2D point2D, int sideLength1, int sideLength2) {
        super(point2D);
        setSideLength1(sideLength1);
        setSideLength2(sideLength2);
    }

    public Rectangle(Point2D point2D) {
        super(point2D);
    }

    public void setSideLength1(int sideLength1) {
        if (sideLength1 < 0) throw new IllegalArgumentException("Сторона должна быть больше нуля");
        this.sideLength1 = sideLength1;
    }

    public void setSideLength2(int sideLength2) {
        if (sideLength2 < 0) throw new IllegalArgumentException("Сторона должна быть больше нуля");
        this.sideLength2 = sideLength2;
    }

    @Override
    public int area() {
        return sideLength1 * sideLength2;
    }
}
