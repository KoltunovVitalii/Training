package ru.mfti.koltunov.city;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class City {
    private String name;
    private List<Roads> roads;

    public City(City city) {
        this(city.getName(), city.getRoads());
    }

    public City(String name, Roads... roads) {
        setName(name);
        setRoads(roads);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Roads[] getRoads() {
        return roads.toArray(Roads[]::new);
    }

    public void setRoads(Roads... roads) {
        this.roads.clear();
        setRoads(roads);
    }

    public void addRoads(Roads... roads) {
        up: for (int i = 0; i < roads.length; i++) {
            City city = roads[i].getCity();
            for (int j = 0; j < this.roads.size(); j++) {
                if (this.roads.get(j).getCity() == city) {
                    this.roads.get(j).setPrice(roads[i].price);
                    continue up;
                }
            }
            this.roads.add(roads[i]);
        }
    }

    @Override
    public String toString() {
        if (roads != null) {
            return "Город: " + name + " " + "Маршруты: " + roads;
        }
        return "Город: " + name + " " + "Маршрутов нет";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass() || o.getClass() != CityWithTwoWayTraffic.class) return false;
        City city = (City) o;
        return Objects.equals(getName(), city.getName()) && Objects.equals(getRoads(), city.getRoads());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), Arrays.hashCode(getRoads()));
    }
}

