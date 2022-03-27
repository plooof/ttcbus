package ca.justinangue.ttc;

public class TempArray {

    
    public String[] stops = {
            "stop1",
            "stop2",
            "stop3",
            "stop4",
            "stop5",
            "stop6",
            "stop7",
            "stop8",
            "stop9",
            "stop10"
    };

    public String getStop(int order){
        String stop = stops[order];
        return stop;
    }
    
}