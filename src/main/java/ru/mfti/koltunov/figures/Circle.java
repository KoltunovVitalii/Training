package ru.mfti.koltunov.figures;

public class Circle extends Figures{

    int radius;

    public Circle(Point2D point2D, int radius) {
        super(point2D);
        setRadius(radius);
    }

    public void setRadius(int radius) {
        if (radius < 0) throw new IllegalArgumentException("Радиус должен быть больше нуля");
        this.radius = radius;
    }

    @Override
    public int area() {
        return (int) (Math.PI*radius*radius);
    }
}
