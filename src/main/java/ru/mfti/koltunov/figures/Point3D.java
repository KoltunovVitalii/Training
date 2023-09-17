package ru.mfti.koltunov.figures;

public class Point3D extends Point2D {

    int z;

    public Point3D(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }

    public Point3D(Point3D point) {
        super(point);
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    @Override
    public String toString() {
        return "Point3D{" +
                "z=" + z +
                ", x=" + x +
                ", y=" + y +
                '}';
    }

    public double distance(Point3D point3D) {
        return Math.sqrt(Math.pow(this.getX() - point3D.getX(), 2) + Math.pow(this.getY() - point3D.getY(), 2)
                + Math.pow(this.getZ() - point3D.getZ(), 2));
    }
}
