package ru.mfti.koltunov.city;

import java.util.Objects;

public class Roads {
    City city;
    int price;

    public Roads(City city) {
        this.city = city;
    }

    public Roads(City city, int price) {
        this(city);
        this.price = price;
    }

    @Override
    public String toString() {
        return city + " " + price;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Roads roads = (Roads) o;
        return getPrice() == roads.getPrice() && Objects.equals(city.getName(), roads.city.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCity(), getPrice());
    }
}
