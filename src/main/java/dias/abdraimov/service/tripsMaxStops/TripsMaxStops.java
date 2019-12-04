package dias.abdraimov.service.tripsMaxStops;

import dias.abdraimov.model.City;
import dias.abdraimov.model.Graph;

public interface TripsMaxStops {
    Long tripsMaxStops(Graph g, City start, City end, long stops);
}
