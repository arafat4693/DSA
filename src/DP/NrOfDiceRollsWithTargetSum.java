package DP;

import java.util.Arrays;

public class NrOfDiceRollsWithTargetSum {
    int mod = 1000000007;

    public int numRollsToTarget(int n, int k, int target) {
        int[][] cache = new int[n+1][target+1];
        for(int[] row : cache) Arrays.fill(row, -1);
        return solve(n, k, target, cache);
    }

    private int solve(int n, int k, int target, int[][] cache){
        if(target == 0 && n == 0) return 1;
        if(n == 0 || target < 0) return 0;
        if(cache[n][target] != -1) return cache[n][target];

        long ans = 0;

        for(int i = 1; i <= k; i++){
            ans += solve(n-1, k, target-i, cache);
            ans %= mod;
        }

        return cache[n][target] = (int)ans;
    }
}
