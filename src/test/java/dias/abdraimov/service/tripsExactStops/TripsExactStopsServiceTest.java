package dias.abdraimov.service.tripsExactStops;

import dias.abdraimov.model.City;
import dias.abdraimov.model.Graph;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TripsExactStopsServiceTest {
    private final Graph g = new Graph();
    private final TripsExactStops solution = new TripsExactStopsService();

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
    void tripsExactStops() {
        Long result = solution.tripsExactStops(g, new City("A"), new City("C"), 4L);
        assertEquals(Long.valueOf(3L), result);
    }
}