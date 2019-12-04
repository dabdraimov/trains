package dias.abdraimov.service.routesNumber;

import dias.abdraimov.model.City;
import dias.abdraimov.model.Graph;

public interface RoutesNumberWithLessDistance {
    Long routesNumberWithLessDistance(Graph g, City start, City end, Long distance);
}
