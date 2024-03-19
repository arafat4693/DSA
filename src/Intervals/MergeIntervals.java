package Intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> res = new ArrayList<>();
        res.add(intervals[0]);
        int currPos = 0;

        for(int i = 1; i < intervals.length; i++){
            int[] currInterval = res.get(currPos);
            if(currInterval[1] >= intervals[i][0]){
                res.remove(currPos);
                res.add(new int[]{currInterval[0], Math.max(intervals[i][1], currInterval[1])});
            }else{
                res.add(intervals[i]);
                currPos++;
            }
        }

        return res.toArray(new int[res.size()][]);
    }
}
