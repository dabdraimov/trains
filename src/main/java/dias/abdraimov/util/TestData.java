package dias.abdraimov.util;

import dias.abdraimov.model.City;
import dias.abdraimov.model.Route;

import java.util.List;

public class TestData {
    public static final Route ROUTE1 = new Route(List.of(
            new City("A"),
            new City("B"),
            new City("C")
    ));

    public static final Route ROUTE2 = new Route(List.of(
            new City("A"),
            new City("D")
    ));

    public static final Route ROUTE3 = new Route(List.of(
            new City("A"),
            new City("D"),
            new City("C")
    ));

    public static final Route ROUTE4 = new Route(List.of(
            new City("A"),
            new City("E"),
            new City("B"),
            new City("C"),
            new City("D")
    ));

    public static final Route ROUTE5 = new Route(List.of(
            new City("A"),
            new City("E"),
            new City("D")
    ));
}
