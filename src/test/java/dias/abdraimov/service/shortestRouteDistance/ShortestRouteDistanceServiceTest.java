package dias.abdraimov.service.shortestRouteDistance;

import dias.abdraimov.model.City;
import dias.abdraimov.model.Graph;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ShortestRouteDistanceServiceTest {
    private final Graph g = new Graph();
    private final ShortestRouteDistance solution = new ShortestRouteDistanceService();

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
    void shortestRouteDistance1() {
        Long result = solution.shortestRoute(g, new City("A"), new City("C"));
        assertEquals(Long.valueOf(9L), result);
    }

    @Test
    void shortestRouteDistance2() {
        Long result = solution.shortestRoute(g, new City("B"), new City("B"));
        assertEquals(Long.valueOf(9L), result);
    }
}