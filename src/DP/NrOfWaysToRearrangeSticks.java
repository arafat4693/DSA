package DP;

import java.util.Arrays;

public class NrOfWaysToRearrangeSticks {
    private final int mod = 1000000007;
    public int rearrangeSticks(int n, int k) {
        int[][] cache = new int[n+1][k+1];
        for(int[] row : cache) Arrays.fill(row, -1);
        return (int)dfs(n, k, cache);
    }

    private long dfs(int n, int k, int[][] cache){
        if(n == 0 || k == 0) return 0;
        if(n == k) return 1;
        if(cache[n][k] != -1) return cache[n][k];

        long ans = 0;
        ans = (n-1)*dfs(n-1, k, cache);
        ans %= mod;
        ans += dfs(n-1, k-1, cache);
        ans %= mod;

        return cache[n][k] = (int)ans;
    }
}
