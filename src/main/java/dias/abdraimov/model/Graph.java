package dias.abdraimov.model;

import dias.abdraimov.exceptions.NoSuchEdgeException;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Graph {
    private final Map<City, List<Edge>> edges = new HashMap<>();

    public void addEdge(City start, City end, Long distance) {
        if (edges.containsKey(start)) {
            edges.get(start).add(new Edge(end, distance));
        } else {
            List<Edge> cityLinkedList = new LinkedList<>();
            cityLinkedList.add(new Edge(end, distance));
            edges.put(start, cityLinkedList);
        }
    }

    public List<Edge> getEdges(City city) {
        return edges.get(city); // GetOrDefault Test
    }

    public Long getEdgeDistance(City start, City end) throws NoSuchEdgeException {
        List<Edge> temp = edges.get(start);
        for (Edge p : temp ) {
            if (p.getCity().equals(end)) {
                return p.getDistance();
            }
        }

        throw new NoSuchEdgeException();
    }

    public void buildGraph(String[] routes) {
        for (String route: routes) {
            String from = route.substring(0, 1);
            String to = route.substring(1, 2);
            Long distance = Long.parseLong(route.substring(2));
            this.addEdge(new City(from), new City(to), distance);
        }
    }

    @Override
    public String toString() {
        return "Graph{" +
                "edges=" + edges +
                '}';
    }
}
