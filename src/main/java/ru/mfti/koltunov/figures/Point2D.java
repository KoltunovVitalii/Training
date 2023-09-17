package ru.mfti.koltunov.figures;

import java.util.Objects;

public class Point2D implements Cloneable{
    int x;
    int y;

    public Point2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point2D(Point2D point2D) {
        this.x = point2D.x;
        this.y = point2D.y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point2D{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    public Point2D clone() throws CloneNotSupportedException {
        return (Point2D) super.clone();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point2D point2D = (Point2D) o;
        return getX() == point2D.getX() && getY() == point2D.getY();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getX(), getY());
    }

    public double distance(Point2D point2D) {
        return Math.sqrt(Math.pow(this.getX() - point2D.getX(), 2) + Math.pow(this.getY() - point2D.getY(), 2));
    }
}

