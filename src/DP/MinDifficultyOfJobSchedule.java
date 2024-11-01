package DP;

import java.util.Arrays;

public class MinDifficultyOfJobSchedule {
    public int minDifficulty(int[] jobs, int d) {
        int[][] cache = new int[d+1][jobs.length];
        for(int[] row : cache) Arrays.fill(row, -1);

        int ans = solve(jobs, d, 0, cache);
        return ans == Integer.MAX_VALUE/2 ? -1 : ans;
    }

    private int solve(int[] jobs, int d, int idx, int[][] cache){
        if(idx == jobs.length) return 0;
        if(d == 0) return Integer.MAX_VALUE/2;
        if(cache[d][idx] != -1) return cache[d][idx];

        int mx = 0, res = Integer.MAX_VALUE/2;
        for(int i = idx; i < (jobs.length - d + 1); i++){
            mx = Math.max(mx, jobs[i]);
            res = Math.min(res, mx + solve(jobs, d-1, i+1, cache));
        }

        return cache[d][idx] = res;
    }
}
