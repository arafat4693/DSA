package DP;

import java.util.Arrays;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
//        int[] cache = new int[amount+1];
//        Arrays.fill(cache, -1);
//        int ans = dfs(coins, amount, cache);
//        return ans == Integer.MAX_VALUE ? -1 : ans;

        int[] cache = new int[amount+1];
        Arrays.fill(cache, amount+1);
        cache[0] = 0;

        for(int a = 1; a <= amount; a++){
            for(int c : coins){
                if(a - c >= 0){
                    cache[a] = Math.min(cache[a], 1 + cache[a-c]);
                }
            }
        }

        return cache[amount] == amount+1 ? -1 : cache[amount];
    }

    private int dfs(int[] coins, int amount, int[] cache){
        if(amount == 0) return 0;
        if(amount < 0) return Integer.MAX_VALUE;
        if(cache[amount] != -1) return cache[amount];

        int res = Integer.MAX_VALUE;

        for(int c : coins){
            int ans = dfs(coins, amount - c, cache);
            if(ans == Integer.MAX_VALUE) continue;
            res = Math.min(res, 1 + ans);
        }

        return cache[amount] = res;
    }
}
