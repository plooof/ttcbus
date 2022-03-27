package ca.justinangue.ttc.routes;

import ca.justinangue.ttc.Route;

public class r_939a extends Route{

        public String route = "939A";
        public String[] stops = new String[] {
                "Finch West Station",
                "Dufferin Street",
                "Goldfinch Court East",
                "Bathurst Street",
                "Finch Station",
                "Leslie Street East Side",
                "Don Mills Road East Side",
                "Seneca Hill Dr",
                "Victoria Park Avenue",
                "Pharmacy Avenue",
                "Warden Avenue",
                "Birchmount Road",
                "Kennedy Road",
                "Midland Avenue",
                "Brimley Road",
                "McCowan Road",
                "Sheppard Avenue East",
                "Scarborough Centre Station"
        };

    public String getRoute(){
        return route;
    }

    public static r_939a INSTANCE = new r_939a();
}
