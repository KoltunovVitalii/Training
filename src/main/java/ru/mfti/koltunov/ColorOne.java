package ru.mfti.koltunov;

public class ColorOne {
    private String color;

    public ColorOne(String color) {
        setColor(color);
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "ColorOne{" +
                "color='" + color + '\'' +
                '}';
    }
}
