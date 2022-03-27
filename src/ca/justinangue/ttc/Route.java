package ca.justinangue.ttc;

import ca.justinangue.ttc.routes.r_939a;

public class Route {

    String route;
    String[] stops = new String[]
    { "N/A", "N/A", "N/A" };

    public String getStop(int order, String[] stopArray) {
        String stop = stopArray[order];
        return stop;
    }

    public static final Route INSTANCE = new Route();
}