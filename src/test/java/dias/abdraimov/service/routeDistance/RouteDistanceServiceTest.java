package dias.abdraimov.service.routeDistance;

import dias.abdraimov.exceptions.NoSuchRouteException;
import dias.abdraimov.model.City;
import dias.abdraimov.model.Graph;
import dias.abdraimov.model.Route;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RouteDistanceServiceTest {
    private final Graph g = new Graph();
    private final RouteDistance solution = new RouteDistanceService();

    @BeforeEach
    void loadGraph() {
        g.addEdge(new City("A"), new City("B"), 5L);
        g.addEdge(new City("B"), new City("C"), 4L);
        g.addEdge(new City("C"), new City("D"), 8L);
        g.addEdge(new City("D"), new City("C"), 8L);
        g.addEdge(new City("D"), new City("E"), 6L);
        g.addEdge(new City("A"), new City("D"), 5L);
        g.addEdge(new City("C"), new City("E"), 2L);
        g.addEdge(new City("E"), new City("B"), 3L);
        g.addEdge(new City("A"), new City("E"), 7L);
    }

    @Test
    void checkRouteDistance1() throws NoSuchRouteException {
        Route route = new Route(List.of(
                new City("A"),
                new City("B"),
                new City("C")
        ));

        Long result = solution.distance(g, route);
        assertEquals(Long.valueOf(9L), result);
    }

    @Test
    void checkRouteDistance2() throws NoSuchRouteException {
        Route route = new Route(List.of(
                new City("A"),
                new City("D")
        ));

        Long result = solution.distance(g, route);
        assertEquals(Long.valueOf(5L), result);
    }

    @Test
    void checkRouteDistance3() throws NoSuchRouteException {
        Route route = new Route(List.of(
                new City("A"),
                new City("D"),
                new City("C")
        ));

        Long result = solution.distance(g, route);
        assertEquals(Long.valueOf(13L), result);
    }

    @Test
    void checkRouteDistance4() throws NoSuchRouteException {
        Route route = new Route(List.of(
                new City("A"),
                new City("E"),
                new City("B"),
                new City("C"),
                new City("D")
        ));

        Long result = solution.distance(g, route);
        assertEquals(Long.valueOf(22L), result);
    }

    @Test
    void checkRouteDistance5() {
        Route route = new Route(List.of(
                new City("A"),
                new City("E"),
                new City("D")
        ));

        assertThrows(NoSuchRouteException.class,() -> solution.distance(g, route));
    }
}