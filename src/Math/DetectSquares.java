package Math;

import java.awt.*;
import java.util.HashMap;

public class DetectSquares {
    private HashMap<Point, Integer> freq;
    public DetectSquares() {
        this.freq = new HashMap<>();
    }

    public void add(int[] point) {
        Point p = new Point(point[0], point[1]);
        freq.put(p, freq.getOrDefault(p, 0) + 1);
    }

    public int count(int[] point) {
        int total = 0;
        Point q = new Point(point[0], point[1]);
        for(Point p : freq.keySet()){
            if(!p.equals(q) && Math.abs(q.getY()-p.getY()) == Math.abs(q.getX()-p.getX())){
                Integer p1 = freq.get(new Point((int)p.getX(), (int)q.getY()));
                Integer p2 = freq.get(new Point((int)q.getX(), (int)p.getY()));

                if(p1 != null && p2 != null ){
                    total += (p1*p2*freq.get(p));
                }
            }
        }
        return total;
    }
}
