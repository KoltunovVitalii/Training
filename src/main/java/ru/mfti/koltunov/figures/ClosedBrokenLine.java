package ru.mfti.koltunov.figures;

public class ClosedBrokenLine extends BrokenLine implements Iterable<Point2D>{
    public ClosedBrokenLine() {
        super();
    }

    public ClosedBrokenLine(Point2D[] point2D) {
        super(point2D);
    }

    public double getLength() {
        double result = super.getLength();
        if(super.getLength() > 1) {
            result += super.getLength() + (Math.sqrt(Math.pow(point2D[point2D.length].getX() - point2D[0].getX(), 2)
                    + Math.pow(point2D[point2D.length].getY() - point2D[0].getY(), 2)));
        }
        return result;
    }

    public static void main(String[] args) {
        BrokenLine bl = new BrokenLine();
        bl.point2D = new Point2D[]{new Point2D(2, 4), new Point2D(4, 4), new Point2D(7, 4),
                new Point2D(2, 4)};
        for (Point2D p : bl) {
            System.out.println(p);
        }
    }
}
