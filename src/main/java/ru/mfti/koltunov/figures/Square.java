package ru.mfti.koltunov.figures;

public class Square extends Rectangle implements BrokenLineable{

    public Square(Point2D point2D, int sideLength1) {
        super(point2D);
        setSideLength(sideLength1);

    }

    public Point2D getPoint() {
        return point2D;
    }


    public int getSideLength() {
        return sideLength1;
    }

    public void setSideLength(int sideLength) {
        if (sideLength < 1) {
            throw new IllegalArgumentException("Сторона квадрата меньше 1!");
        }
        this.sideLength1 = sideLength;
    }

    @Override
    public String toString() {
        return "Квадрат в точке: " + point2D +
                " со стороной: " + sideLength1;
    }

    public BrokenLine squareToBroken() {
        Point2D point2D1 = new Point2D(point2D.x, point2D.y);
        Point2D point2D2 = new Point2D(point2D.x + sideLength1, point2D.y);
        Point2D point2D3 = new Point2D(point2D.x + sideLength1, point2D.y - sideLength1);
        Point2D point2D4 = new Point2D(point2D.x, point2D.y - sideLength1);
        return new ClosedBrokenLine(new Point2D[]{point2D1, point2D2, point2D3, point2D4});
    }

    @Override
    public int area() {
        return sideLength1 * sideLength1;
    }

    @Override
    public BrokenLine getPolygonalChain() {
        return new BrokenLine(getPolygonalChain().point2D);
    }
}
