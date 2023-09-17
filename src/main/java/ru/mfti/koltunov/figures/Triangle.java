package ru.mfti.koltunov.figures;

public class Triangle extends Figures {

    Point2D point2D1;
    Point2D point2D2;

    public Triangle(Point2D point2D, Point2D point2D1, Point2D point2D2) {
        super(point2D);
        this.point2D1 = point2D1;
        this.point2D2 = point2D2;
    }

    @Override
    public int area() {
        return  Math.abs((point2D1.x - point2D.x)*(point2D2.y - point2D.y) - (point2D2.x - point2D.x)*(point2D1.y - point2D.y)) / 2;
    }
}
