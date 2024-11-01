package ArrayAndHashing;

import java.util.HashMap;
import java.util.List;

public class UndergroundSystem {
    class Travle{
        String place;
        int time;
        Travle(String place, int time){
            this.place = place;
            this.time = time;
        }
    }


    private HashMap<Integer, Travle> check;
    private HashMap<String, int[]> avgTime;
    public UndergroundSystem() {
        this.check = new HashMap<>();
        this.avgTime = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        Travle trv = new Travle(stationName, t);
        check.put(id, trv);
    }

    public void checkOut(int id, String stationName, int t) {
        Travle trv = check.get(id);
        StringBuilder p = new StringBuilder().append(trv.place).append("->").append(stationName);
        int diff = t - trv.time;
        // System.out.println(p);
        // System.out.println(diff);
        int[] old = avgTime.getOrDefault(p.toString(), new int[]{0,0});

        avgTime.put(p.toString(), new int[]{old[0]+diff, old[1]+1});
    }

    public double getAverageTime(String startStation, String endStation) {
        StringBuilder p = new StringBuilder().append(startStation).append("->").append(endStation);
        int[] avg = avgTime.get(p.toString());
        return (double) avg[0] / avg[1];
    }
}
