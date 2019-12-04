package dias.abdraimov.service.shortestRouteDistance;

import dias.abdraimov.model.City;
import dias.abdraimov.model.Graph;

public interface ShortestRouteDistance {

    Long shortestRoute(Graph g, City start, City end);

}
