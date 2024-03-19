package DP;

import java.util.Arrays;

public class CoinChangeTwo {
    public int change(int amount, int[] coins) {
//        int[][] cache = new int[coins.length][amount+1];
//        for(int i = 0; i < coins.length; i++){
//            for(int j = 1; j < amount+1; j++) cache[i][j] = -1;
//        }
//        return dfs(amount, 0, coins, cache);

        int[][] cache = new int[coins.length+1][amount+1];

        for(int i = 0; i < coins.length; i++) cache[i][0] = 1;

        for(int idx = coins.length-1; idx >= 0; idx--){
            for(int a = 1; a < amount+1; a++){
                cache[idx][a] = cache[idx+1][a] + (a-coins[idx] < 0 ? 0 : cache[idx][a-coins[idx]]);
            }
        }
        System.out.println(Arrays.deepToString(cache));
        return cache[0][amount];
    }

    private int dfs(int amount, int idx, int[] coins, int[][] cache){
        if(amount == 0) return 1;
        if(idx >= coins.length || amount < 0) return 0;
        if(cache[idx][amount] != -1) return cache[idx][amount];

        int ans = dfs(amount, idx+1, coins, cache);
        ans += dfs(amount - coins[idx], idx, coins, cache);

        return cache[idx][amount] = ans;
    }
}