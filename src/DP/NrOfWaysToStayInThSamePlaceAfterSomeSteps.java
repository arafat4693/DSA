package DP;

import java.util.Arrays;

public class NrOfWaysToStayInThSamePlaceAfterSomeSteps {
    int mod = 1000000007;
    public int numWays(int steps, int arrLen) {
        int[][] cache = new int[steps+1][Math.min(steps, arrLen)];
        for(int[] row : cache) Arrays.fill(row, -1);
        return (int)dfs(steps, arrLen, 0, cache);
    }

    private long dfs(int steps, int arrLen, int idx, int[][] cache){
        if(idx < 0 || idx >= arrLen || (steps == 0 && idx != 0)) return 0;
        if(steps == 0) return 1;
        if(cache[steps][idx] != -1) return cache[steps][idx];

        long ans = (dfs(steps-1, arrLen, idx, cache)%mod +
                dfs(steps-1, arrLen, idx+1, cache)%mod +
                dfs(steps-1, arrLen, idx-1, cache)%mod)%mod;

        return cache[steps][idx] = (int)ans;
    }
}
