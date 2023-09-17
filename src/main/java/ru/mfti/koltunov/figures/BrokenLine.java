package ru.mfti.koltunov.figures;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.stream.Stream;

public class BrokenLine implements LehgthOfLines, BrokenLineable, Iterable<Point2D> {
    public Point2D[] point2D;


    public BrokenLine() {
        BrokenLine bl = new BrokenLine();
    }

    public BrokenLine(Point2D[] point2D) {
        this();
        this.point2D = point2D;
    }

    @Override
    public String toString() {
        return "Ломаная" + Arrays.toString(point2D);
    }


    public BrokenLine append(BrokenLine brokenLine) {
        Point2D[] point2DS = new Point2D[point2D.length + brokenLine.getPoint2D().length];
        int count = 0;
        for (int i = 0; i < point2D.length; i++) {
            point2DS[i] = point2D[i];
            count++;
        }
        for (Point2D newPoint2D : brokenLine) {
            point2DS[count++] = newPoint2D;
        }
        return new BrokenLine(point2DS);
    }
    public BrokenLine add(Point2D newPoint2D) {
        Point2D[] newPointS2D = new Point2D[point2D.length + 1];
        System.arraycopy(point2D, 0, newPointS2D, 0, point2D.length);
        newPointS2D[newPointS2D.length - 1] = newPoint2D;
        return new BrokenLine(newPointS2D);
    }

    public Point2D[] getPoint2D() {
        return point2D;
    }

    public double getLength() {
        if (point2D.length < 1) return 0;
        double length = 0;
        for (int i = 0; i < point2D.length - 1; i++) {
            length = length + Math.sqrt(Math.pow(point2D[i].getX() - point2D[i + 1].getX(), 2)
                    + Math.pow(point2D[i].getY() - point2D[i + 1].getY(), 2));
        }
        return length;
    }

    @Override
    public BrokenLine getPolygonalChain() {
        return new BrokenLine(getPolygonalChain().point2D);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BrokenLine that = (BrokenLine) o;
        return Arrays.equals(point2D, that.point2D);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(point2D);
    }

    @Override
    protected BrokenLine clone() throws CloneNotSupportedException {
        BrokenLine brokenLine = (BrokenLine) super.clone();
        brokenLine.point2D = brokenLine.point2D.clone();
        for (int i = 0; i < point2D.length; i++) {
            brokenLine.point2D[i] = brokenLine.point2D[i].clone();
        }
        return brokenLine;
    }


    int currentIteratorIndex = 0;
    @Override
    public Iterator<Point2D> iterator() {
        return new Iterator<Point2D>() {
            @Override
            public boolean hasNext() {
                return currentIteratorIndex < point2D.length;
            }
            @Override
            public Point2D next() {
                return point2D[currentIteratorIndex++];
            }
        };
    }

    public static void main(String[] args) {
//        BrokenLine bl = new BrokenLine();
//        bl.point2D = new Point2D[]{new Point2D(2, 4), new Point2D(4, 4), new Point2D(7, 4),
//                new Point2D(9, 4)};
//        for (Point2D p : bl) {
//            System.out.println(p);
//        }
        BrokenLine brokenLine = Stream.of(new Point2D (4, 5), new Point2D (2, -5), new Point2D (6, 5),
                new Point2D (4, 7), new Point2D (0, -7))
                .distinct()
                .sorted(Comparator.comparingInt(o -> o.x))
                .map(point2D -> new Point2D(point2D.x, Math.abs(point2D.y)))
                .collect(
                        BrokenLine::new,
                        BrokenLine::add,
                        BrokenLine::append);

    }
}

