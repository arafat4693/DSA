package DP;

import java.util.Arrays;

public class ProfitableSchemes {
    int mod = (int) Math.pow(10, 9) + 7;
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
//        int[][][] cache = new int[group.length][n+1][minProfit+1];
//
//        for (int i = 0; i < group.length; i++) {
//            for (int j = 0; j < n + 1; j++) {
//                for (int k = 0; k <= minProfit; k++) {
//                    cache[i][j][k] = -1;
//                }
//            }
//        }
//
//        return (int) dfs(n,0, group, profit, minProfit, 0, cache);

        int[][][] cache = new int[group.length+1][n+1][minProfit+1];

        for(int j = 0; j < n+1; j++) cache[group.length][j][minProfit] = 1;

        for (int i = group.length-1; i >= 0; i--) {
            for (int j = 0; j < n+1; j++) {
                for (int k = 0; k <= minProfit; k++) {

                    long ans = cache[i+1][j][k];
                    if(group[i] <= j) ans += cache[i+1][j-group[i]][Math.min(k+profit[i], minProfit)];

                    cache[i][j][k] = (int)ans%mod;
                }
            }
        }

        return cache[0][n][0];
    }

    private long dfs(int n, int idx, int[] group, int[] profit, int minProfit, int currProfit, int[][][] cache){
        if(idx >= group.length && idx >= profit.length) return currProfit >= minProfit ? 1 : 0;
        if(cache[idx][n][Math.min(currProfit, minProfit)] != -1) return cache[idx][n][Math.min(currProfit, minProfit)];

        long ans = dfs(n,idx+1, group, profit, minProfit, currProfit, cache);
        if(group[idx] <= n) ans += dfs(n-group[idx], idx+1, group, profit, minProfit, currProfit+profit[idx], cache);

        return cache[idx][n][Math.min(currProfit, minProfit)] = (int)ans%mod;
    }
}
