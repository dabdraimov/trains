package dias.abdraimov.service.routeDistance;

import dias.abdraimov.exceptions.NoSuchRouteException;
import dias.abdraimov.model.City;
import dias.abdraimov.model.Graph;
import dias.abdraimov.model.Route;

import java.util.List;

public class RouteDistanceService implements RouteDistance {

    @Override
    public Long distance(Graph g, Route route) throws NoSuchRouteException {

        List<City> cities = route.getCities();

        if (cities.size() < 2) {
            throw new NoSuchRouteException();
        }

        try {
            Long result = 0L;

            for (int i = 1; i < cities.size(); i++) {
                City start = cities.get(i - 1);
                City next = cities.get(i);
                result = result + g.getEdgeDistance(start, next);
            }

            return result;
        } catch (Exception e) {
            throw new NoSuchRouteException();
        }
    }
}
