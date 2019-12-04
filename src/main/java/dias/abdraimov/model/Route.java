package dias.abdraimov.model;

import java.util.List;

public class Route {
    private final List<City> cities;

    public Route(List<City> cities) {
        this.cities = cities;
    }

    public List<City> getCities() {
        return cities;
    }

    @Override
    public String toString() {
        return "Route{" +
                "cities=" + cities +
                '}';
    }
}
