package ru.mfti.koltunov;

public class House {
    private int floor;

    public House(int floor) {
        setFloor(floor);
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        if (floor < 1) {
            throw new IllegalArgumentException("этажей меньше 1!");
        }
        this.floor = floor;
    }

    @Override
    public String toString() {
        String result = "дом с " + floor;
        if (floor%10 == 1) {
            result = result + " этажом";
        } else {
            result = result + " этажами";
        }
        return result;
    }
}
