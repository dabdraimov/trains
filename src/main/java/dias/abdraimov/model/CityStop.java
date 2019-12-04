package dias.abdraimov.model;

public class CityStop {
    private final City city;
    private final Long stop;
    private final Route route;

    public CityStop(City city, Long stop, Route route) {
        this.city = city;
        this.stop = stop;
        this.route = route;
    }

    public City getCity() {
        return city;
    }

    public Long getStop() {
        return stop;
    }

    public Route getRoute() {
        return route;
    }

    @Override
    public String toString() {
        return "CityStop{" +
                "city=" + city +
                ", stop=" + stop +
                ", route=" + route +
                '}';
    }
}
