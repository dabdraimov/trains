package dias.abdraimov.service.routeDistance;

import dias.abdraimov.exceptions.NoSuchRouteException;
import dias.abdraimov.model.Graph;
import dias.abdraimov.model.Route;

public interface RouteDistance {

    Long distance(Graph g, Route route) throws NoSuchRouteException;

}
