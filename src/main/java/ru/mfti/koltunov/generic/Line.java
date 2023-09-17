package ru.mfti.koltunov.generic;

import ru.mfti.koltunov.figures.LehgthOfLines;
import ru.mfti.koltunov.figures.Point2D;
import ru.mfti.koltunov.figures.Point3D;

import java.util.Objects;

public class Line<T extends Point2D> implements LehgthOfLines, Cloneable{
    private T start;
    private T end;

    public Line(T start, T end) {
        this.start = start;
        this.end = end;
    }


    public static Line<Point2D> twoD(int startX, int startY, int endX, int endY) {
        return new Line<>(new Point2D(startX, startY), new Point2D(endX, endY));
    }

    public static Line<Point3D> threeD(int startX, int startY, int startZ, int endX, int endY, int endZ) {
        return new Line<>(new Point3D(startX, startY, startZ), new Point3D(endX, endY, endZ));
    }

    @Override
    public String toString() {
        return "Линия. " +
                "start=" + start +
                ", end=" + end;
    }

    public T getStart() {
        return start;
    }

    public void setStart(T start) throws CloneNotSupportedException {
        this.start = (T) start.clone();
    }

    public T getEnd() {
        return end;
    }

    public void setEnd(Point2D end) throws CloneNotSupportedException {
        this.end = (T) end.clone();
    }

    public double getLength() {
        return start.distance(end);
    }

    @Override
    protected Line clone() throws CloneNotSupportedException {
        Line line = (Line) super.clone();
        line.setStart(line.start.clone());
        line.setEnd(line.end.clone());
        return  line;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return Objects.equals(getStart(), line.getStart()) && Objects.equals(getEnd(), line.getEnd());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStart(), getEnd());
    }
}
