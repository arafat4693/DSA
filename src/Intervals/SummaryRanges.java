package Intervals;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class SummaryRanges {
    private TreeSet<Integer> set;
    public SummaryRanges() {
        set = new TreeSet<>();
    }

    public void addNum(int value) {
        set.add(value);
    }

    public int[][] getIntervals() {
        List<int[]> intervals = new ArrayList<>();

        for(int n : set){
            if(!intervals.isEmpty() && intervals.get(intervals.size()-1)[1]+1 == n){
                intervals.get(intervals.size()-1)[1]++;
            }else intervals.add(new int[]{n, n});
        }

        int[][] res = new int[intervals.size()][2];
        for(int i = 0; i < intervals.size(); i++){
            res[i] = intervals.get(i);
        }

        return res;
    }
}
