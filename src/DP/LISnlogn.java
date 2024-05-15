package DP;

import java.util.ArrayList;
import java.util.List;

public class LISnlogn {
    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        List<Integer> lis = new ArrayList<>();
        int[] res = new int[obstacles.length];
        for(int i = 0; i < obstacles.length; i++){
            int idx = upperBound(lis, obstacles[i]);
            if(idx == lis.size()) lis.add(obstacles[i]);
            else lis.set(idx, obstacles[i]);
            res[i] = idx+1;
        }
        return res;
    }

    private int upperBound(List<Integer> lis, int t){
        int l = 0, r = lis.size()-1, ans = lis.size();
        while(l <= r){
            int m = (l+r)/2;
            if(lis.get(m) <= t) l = m+1;
            else{
                r = m-1;
                ans = m;
            }
        }

        return ans;
    }
}
