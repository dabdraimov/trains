package dias.abdraimov.service.tripsExactStops;

import dias.abdraimov.model.City;
import dias.abdraimov.model.Graph;

public interface TripsExactStops {
    Long tripsExactStops(Graph g, City start, City end, long stops);
}
