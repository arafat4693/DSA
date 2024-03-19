package DP;

import java.util.Arrays;

public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
//        int[] cache = new int[cost.length];
//        return Math.min(dfs(0, cache, cost), dfs(1, cache, cost));
        int one = cost[cost.length - 2], two = cost[cost.length - 1];
        for(int i = cost.length - 3; i >= 0; i--){
            int tmp = one;
            one = cost[i] + Math.min(one, two);
            two = tmp;
        }
        return Math.min(one, two);
    }

    private int dfs(int f, int[] cache, int[] cost){
        if(f >= cost.length) return 0;
        if(cache[f] != 0) return cache[f];

        int res = cost[f] + Math.min(dfs(f+1, cache, cost), dfs(f+2, cache, cost));
        cache[f] = res;
        return res;
    }
}
