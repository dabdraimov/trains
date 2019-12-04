package dias.abdraimov.controller;

import dias.abdraimov.exceptions.NoSuchRouteException;
import dias.abdraimov.model.City;
import dias.abdraimov.model.Graph;
import dias.abdraimov.model.Route;
import dias.abdraimov.service.routeDistance.RouteDistance;
import dias.abdraimov.service.routeDistance.RouteDistanceService;
import dias.abdraimov.service.routesNumber.RoutesNumberWithLessDistance;
import dias.abdraimov.service.routesNumber.RoutesNumberWithLessDistanceService;
import dias.abdraimov.service.shortestRouteDistance.ShortestRouteDistance;
import dias.abdraimov.service.shortestRouteDistance.ShortestRouteDistanceService;
import dias.abdraimov.service.tripsExactStops.TripsExactStops;
import dias.abdraimov.service.tripsExactStops.TripsExactStopsService;
import dias.abdraimov.service.tripsMaxStops.TripsMaxStops;
import dias.abdraimov.service.tripsMaxStops.TripsMaxStopsService;

public class MainController {
    private final RouteDistance routeDistance = new RouteDistanceService();
    private final ShortestRouteDistance shortestRouteDistance = new ShortestRouteDistanceService();
    private final TripsMaxStops tripsMaxStops = new TripsMaxStopsService();
    private final TripsExactStops tripsExactStops = new TripsExactStopsService();
    private final RoutesNumberWithLessDistance routesNumberWithLessDistance = new RoutesNumberWithLessDistanceService();

    public void distance(Graph g, Route route) {
        try {
            System.out.println(routeDistance.distance(g, route));
        } catch (NoSuchRouteException e) {
            System.out.println("NO SUCH ROUTE");
        }
    }

    public void routesNumberWithLessDistance(Graph g, City start, City end, Long distance) {
        System.out.println(routesNumberWithLessDistance.routesNumberWithLessDistance(g, start, end, distance));
    }

    public void shortestRoute(Graph g, City start, City end) {
        System.out.println(shortestRouteDistance.shortestRoute(g, start, end));
    }

    public void tripsExactStops(Graph g, City start, City end, long stops) {
        System.out.println(tripsExactStops.tripsExactStops(g, start, end, stops));
    }

    public void tripsMaxStops(Graph g, City start, City end, long stops) {
        System.out.println(tripsMaxStops.tripsMaxStops(g, start, end, stops));
    }
}
