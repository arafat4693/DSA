package Intervals;

import java.util.Arrays;

public class RemoveCoveredIntervals {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if(a[0] == b[0]) return b[1] - a[1];
            return a[0] - b[0];
        });

        int c = 0;
        int[] curr = intervals[0];

        for(int i = 1; i < intervals.length; i++){
            int s1 = curr[0], e1 = curr[1];
            int s2 = intervals[i][0], e2 = intervals[i][1];

            if(s1 <= s2 && e2 <= e1) c++;
            else curr = intervals[i];
        }

        return intervals.length - c;
    }
}
