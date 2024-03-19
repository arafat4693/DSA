package DP;

import java.util.Arrays;

public class BestTimeToBuySellCooldown {
    public int maxProfit(int[] prices) {
//        int[][] cache = new int[prices.length][3];
//        for(int i = 0; i < prices.length; i++){
//            for(int j = 0; j < 3; j++) cache[i][j] = -1;
//        }
//        return dfs(prices, 0, 1, cache);

        int[][] cache = new int[prices.length+1][3];

        for(int idx = prices.length-1; idx >= 0; idx--){
            for(int state = 0; state < 3; state++){
                if(state == 2){ // cool down
                    cache[idx][state] = cache[idx+1][1];
                }else if(state == 1){ // buy
                    cache[idx][state] = Math.max(-prices[idx] + cache[idx+1][0], cache[idx+1][1]);
                }else{ // sell
                    cache[idx][state] = Math.max(prices[idx] + cache[idx+1][2], cache[idx+1][0]);
                }
            }
        }

        return cache[0][1];
    }

    private int dfs(int[] prices, int idx, int state, int[][] cache){
        if(idx >= prices.length) return 0;
        if(cache[idx][state] != -1) return cache[idx][state];

        if(state == 2){ // cool down
            cache[idx][state] = dfs(prices, idx+1, 1, cache);
        }else if(state == 1){ // buy
            cache[idx][state] = Math.max(-prices[idx] + dfs(prices, idx+1, 0, cache), dfs(prices, idx+1, 1, cache));
        }else{ // sell
            cache[idx][state] = Math.max(prices[idx] + dfs(prices, idx+1, 2, cache), dfs(prices, idx+1, 0, cache));
        }

        return cache[idx][state];
    }
}
