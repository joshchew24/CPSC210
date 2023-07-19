package model;

import java.util.HashSet;
import java.util.Set;

public class FlightMap {

    private Set<Route> routes;

    public FlightMap() {
        routes = new HashSet<>();
    }

    public boolean addRoute(Route route) {
        return routes.add(route);
    }

    public boolean removeRoute(Route route) {
        return routes.remove(route);
    }
}
