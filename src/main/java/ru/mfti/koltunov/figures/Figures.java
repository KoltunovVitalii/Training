package ru.mfti.koltunov.figures;

public abstract class Figures {

    Point2D point2D;

    public Figures(Point2D point2D) {
        this.point2D = point2D;
    }

    public abstract int area();
}
