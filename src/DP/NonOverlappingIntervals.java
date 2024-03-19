package DP;

import java.util.Arrays;

// Go to -> MaxEvents2
public class NonOverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int[] cache = new int[intervals.length];
        Arrays.fill(cache, -1);
        return dfs(intervals, 0, cache);
    }

    private int dfs(int[][] intervals, int idx, int[] cache){
        if(idx >= intervals.length) return 0;
        if(cache[idx] != -1) return cache[idx];

        int next = getNext(intervals, idx);

        int ans = Integer.MAX_VALUE;

        if(next == -1 || next - idx > 1) ans = Math.min(dfs(intervals, idx+1, cache)+1, ans);

        if(next == -1) ans = Math.min(ans, intervals.length - 1 - idx);
        else ans = Math.min(dfs(intervals, next, cache)+(next-idx-1), ans);

        return cache[idx] = ans;
    }

    private int getNext(int[][] intervals, int idx){
        int low = idx + 1;
        int high = intervals.length - 1;
        int next = -1, target = intervals[idx][1];

        while(low <= high){
            int mid = (low + high) / 2;
            if(intervals[mid][0] >= target){
                high = mid - 1;
                next = mid;
            }else low = mid + 1;
        }

        return next;
    }
}
