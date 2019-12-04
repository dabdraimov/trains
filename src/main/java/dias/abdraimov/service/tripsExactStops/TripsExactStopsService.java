package dias.abdraimov.service.tripsExactStops;

import dias.abdraimov.model.City;
import dias.abdraimov.model.CityStop;
import dias.abdraimov.model.Edge;
import dias.abdraimov.model.Graph;
import dias.abdraimov.model.Route;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TripsExactStopsService implements TripsExactStops {

    @Override
    public Long tripsExactStops(Graph g, City start, City end, long stops) {
        Queue<CityStop> q = new LinkedList<>();

        q.add(new CityStop(start, 0L, new Route(List.of(start))));

        Long result = 0L;

        while (!q.isEmpty()) {
            CityStop current = q.poll();
            List<City> currentRoute = current.getRoute().getCities();

            if (current.getStop() < stops) {
                List<Edge> edges = g.getEdges(current.getCity());

                edges.forEach(edge -> {
                    List<City> newRoute = new ArrayList<>(currentRoute);
                    newRoute.add(edge.getCity());
                    q.add(
                            new CityStop(
                                    edge.getCity(),
                                    current.getStop() + 1,
                                    new Route(newRoute)
                            )
                    );
                });
            }

            if (current.getStop() == stops && current.getCity().equals(end) && current.getRoute().getCities().size() > 1) {
                result++;
            }
        }

        return result;
    }
}
