package ru.mfti.koltunov.city;

public class CityWithTwoWayTraffic extends City {

    public CityWithTwoWayTraffic(City city) {
        super(city);
    }

    public CityWithTwoWayTraffic(String name, Roads... roads) {
        super(name, roads);
    }

    public void addRoads(Roads... roads) {
        super.addRoads();
        for (Roads road : roads) {
            if (road.getCity().getRoads() == this.getRoads()){
                road.getCity().addRoads(new Roads(this, road.getPrice()));
            }
        }
    }
}
