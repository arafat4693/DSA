package Intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertIntervals {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();

        for(int i = 0; i < intervals.length; i++){
            if(newInterval[1] < intervals[i][0]){
                res.add(newInterval);
                for(int j = i; j < intervals.length; j++) res.add(intervals[j]);
                return convertToArr(res);
            }else if(newInterval[0] > intervals[i][1]){
                res.add(intervals[i]);
            }else{
                newInterval = new int[]{Math.min(newInterval[0], intervals[i][0]), Math.max(newInterval[1], intervals[i][1])};
            }
        }

        res.add(newInterval);
        return convertToArr(res);
    }

    private int[][] convertToArr(List<int[]> res){
        int[][] output = new int[res.size()][2];
        for(int i = 0; i < res.size(); i++) output[i] = res.get(i);
        return output;
    }
}
