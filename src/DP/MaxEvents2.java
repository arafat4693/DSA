package DP;

import java.util.Arrays;

public class MaxEvents2 {
    public int maxValue(int[][] events, int k) {
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        int[][] cache = new int[k+1][events.length];
        return dfs(events, k, 0, cache);
    }

    private int dfs(int[][] events, int k, int idx, int[][] cache){
        if(k == 0 || idx < 0 || idx >= events.length) return 0;
        if(cache[k][idx] != 0) return cache[k][idx];

        int ans = 0;
        ans = Math.max(dfs(events, k, idx+1, cache), ans);
        ans = Math.max(events[idx][2] + dfs(events, k-1, getNextEvent(events, idx), cache), ans);

        return cache[k][idx] = ans;
    }

    private int getNextEvent(int[][] events, int idx){
        int low = idx+1;
        int high = events.length-1;
        int nextEvent = -1, target = events[idx][1]+1;

        while(low <= high){
            int mid = (low + high) / 2;
            if(events[mid][0] >= target){
                nextEvent = mid;
                high = mid - 1;
            }else low = mid + 1;
        }

        return nextEvent;
    }
}
