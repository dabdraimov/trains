package dias.abdraimov;

import dias.abdraimov.controller.MainController;
import dias.abdraimov.model.City;
import dias.abdraimov.model.Graph;
import dias.abdraimov.util.TestData;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

class Main {

    public static void main(String[] args) {
        MainController mainController = new MainController();
        Graph graphInput = new Graph();

        try {
            InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("input.txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String line;
            StringBuilder builder = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                builder.append(line);
                String[] routes = line.split(", ");
                graphInput.buildGraph(routes);
            }
            reader.close();

            System.out.println("Given input: " + builder.toString());

            mainController.distance(graphInput, TestData.ROUTE1);
            mainController.distance(graphInput, TestData.ROUTE2);
            mainController.distance(graphInput, TestData.ROUTE3);
            mainController.distance(graphInput, TestData.ROUTE4);
            mainController.distance(graphInput, TestData.ROUTE5);
            mainController.tripsMaxStops(graphInput, new City("C"), new City("C"), 3);
            mainController.tripsExactStops(graphInput, new City("A"), new City("C"), 4);
            mainController.shortestRoute(graphInput, new City("A"), new City("D"));
            mainController.shortestRoute(graphInput, new City("B"), new City("B"));
            mainController.routesNumberWithLessDistance(graphInput, new City("C"), new City("C"), 30L);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
