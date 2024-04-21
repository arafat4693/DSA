package ArrayAndHashing;

import java.util.HashMap;
import java.util.List;

public class BrickWall {
    public int leastBricks(List<List<Integer>> wall) {
        HashMap<Integer, Integer> gaps = new HashMap<>();

        for(List<Integer> w : wall){
            int t = 0;
            for(int i = 0; i < w.size()-1; i++){
                t += w.get(i);
                gaps.put(t, gaps.getOrDefault(t, 0)+1);
            }
        }

        int mx = 0;
        for(int g : gaps.keySet()) mx = Math.max(mx, gaps.get(g));

        return wall.size() - mx;
    }
}
