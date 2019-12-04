package dias.abdraimov.model;

public class Edge {
    private final City city;
    private final Long distance;

    Edge(City city, Long distance) {
        this.city = city;
        this.distance = distance;
    }

    public Edge(Long distance, City city) {
        this.city = city;
        this.distance = distance;
    }

    public City getCity() {
        return city;
    }

    public Long getDistance() {
        return distance;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "city=" + city +
                ", distance=" + distance +
                '}';
    }
}
