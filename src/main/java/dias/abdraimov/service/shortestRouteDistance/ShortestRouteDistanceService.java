package dias.abdraimov.service.shortestRouteDistance;

import dias.abdraimov.model.City;
import dias.abdraimov.model.Edge;
import dias.abdraimov.model.Graph;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class ShortestRouteDistanceService implements ShortestRouteDistance {

    @Override
    public Long shortestRoute(Graph g, City start, City end) {
        if (start.equals(end)) {
            List<Edge> edges = g.getEdges(start);
            List<Long> d = edges.stream()
                    .map(edge -> edge.getDistance() + Dijkstra(g, edge.getCity(), start))
                    .collect(Collectors.toList());

            return Collections.min(d);
        } else {
            return Dijkstra(g, start, end);
        }
    }

    private Long Dijkstra(Graph g, City start, City end) {
        TreeSet<Edge> nodes = new TreeSet<>(Comparator.comparingLong(Edge::getDistance));
        Map<City, Long> distance = new HashMap<>();

        distance.put(start, 0L);
        nodes.add(new Edge(0L, start));

        while (!nodes.isEmpty()) {
            Edge current = nodes.pollFirst();

            City currentCity = current.getCity();
            Long currentDistance = distance.get(currentCity);

            for (Edge edges : g.getEdges(currentCity)) {
                City nextCity = edges.getCity();
                Long len = edges.getDistance();

                Long nextDistance = distance.getOrDefault(nextCity, Long.MAX_VALUE);

                if (currentDistance + len < nextDistance) {
                    nodes.remove(new Edge(distance.getOrDefault(nextCity, Long.MAX_VALUE), nextCity));
                    distance.put(nextCity, currentDistance + len);
                    nodes.add(new Edge(distance.get(nextCity), nextCity));
                }
            }
        }

        return distance.get(end);
    }
}
