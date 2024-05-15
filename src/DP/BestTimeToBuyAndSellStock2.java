package DP;

import java.util.Arrays;

public class BestTimeToBuyAndSellStock2 {
    public int maxProfit(int[] prices) {
        int[][] cache = new int[prices.length][2];
        for(int[] row : cache) Arrays.fill(row, -1);
        return dfs(0, 1, prices, cache);
    }

    private int dfs(int idx, int isBuy, int[] prices, int[][] cache){
        if(idx >= prices.length) return 0;
        if(cache[idx][isBuy] != -1) return cache[idx][isBuy];

        int ans;
        if(isBuy == 1){
            ans = Math.max(-prices[idx] + dfs(idx, 0, prices, cache), dfs(idx + 1, isBuy, prices, cache));
        }else{
            ans = Math.max(prices[idx] + dfs(idx + 1, 1, prices, cache), dfs(idx + 1, isBuy, prices, cache));
        }

        return cache[idx][isBuy] = ans;
    }
}
