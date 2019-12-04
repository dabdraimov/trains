# Trains and Towns Solution Application using Java

Application is used to solve given graph problem which includes 
finding distance of the route, 
calculating number of trips, 
showing the shortest distance and etc.

## Solution

1. For finding distance for route just traverse each city one by one and sum the distance as in **RouteDistanceService**
2. For finding number of trips starting with maximum N stops implemented modified BFS (Breadth - First Search) algorithm 
where I keep track of visited nodes and take neighbours while checking for needed conditions.
Assuming that we know answer for N -1 and have a list of Cities with N -1 stops, we can easily check edges and find all 
Cities for N as in **TripsMaxStopsService**
3. For finding number of trips with exactly N stops, idea is same as in 2. solution, just modified checking conditions 
as in **TripsExactStopsService**
4. For finding length of shortest distance from different source and destination used regular Dijkstra Algorithm as in 
**ShortestRouteDistanceService**
5. For finding length of shortest distance from same source and destination I implemented
idea where first look for all neighbours going to source and from this list calculate shortest distance where 
this neighbour will be source and destination will input City so I can find minimum among them.
Here Idea is that I will enter the source from neighbour anyway and exit also from neighbour so by counting two sides for 
all neighbours we can know minimum shortest distance as implemented in **ShortestDistanceService**
6. For finding number of different trips with less than distance used the same Idea as in solution 2 using BFS, only 
changing the number of stops to distance and calculating all possible routes as in **RoutesNumberService** 

## Build
```
$ ./gradlew clean build
```

## Run

```
$ java -jar ./build/libs/trains-1.0-SNAPSHOT.jar
```
## Test
```
$ ./gradlew test
```

To start application from IDEA, run dias.abdraimov.Main

### Example
```
java -jar ./build/libs/trains-1.0-SNAPSHOT.jar

9
5
13
22
NO SUCH ROUTE
2
3
5
9
7
```
