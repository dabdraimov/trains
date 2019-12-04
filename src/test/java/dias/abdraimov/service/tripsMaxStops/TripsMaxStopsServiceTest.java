package dias.abdraimov.service.tripsMaxStops;

import dias.abdraimov.model.City;
import dias.abdraimov.model.Graph;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TripsMaxStopsServiceTest {
    private final Graph g = new Graph();
    private final TripsMaxStops solution = new TripsMaxStopsService();

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
    void tripsMaxStops() {
        Long result = solution.tripsMaxStops(g, new City("C"), new City("C"), 3L);
        assertEquals(Long.valueOf(2L), result);
    }
}