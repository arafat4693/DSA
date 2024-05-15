package DP;

import java.sql.Array;
import java.util.Arrays;
import java.util.HashMap;

public class LastStoneWeight2 {
//    public int lastStoneWeightII(int[] stones) {
//        Arrays.sort(stones);
//        int sum = Arrays.stream(stones).sum();
//        int target = (int)Math.ceil((double) sum /2);
//
//        int[][] cache = new int[stones.length][target+1];
//        for(int[] row : cache) Arrays.fill(row, -1);
//
//        int ans = dfs(stones, target, 0, cache);
//        return Math.abs(ans - (sum - ans));
//    }
//
//    private int dfs(int[] stones, int target, int idx, int[][] cache){
//        if(target == 0 || idx >= stones.length || target < stones[idx]) return 0;
//        if(cache[idx][target] != -1) return cache[idx][target];
//
//        return cache[idx][target] = Math.max(
//                dfs(stones, target, idx+1, cache),
//                stones[idx] + dfs(stones, target-stones[idx], idx+1, cache)
//        );
//    }

    public int lastStoneWeightII(int[] stones) {
        int sum = Arrays.stream(stones).sum();
        int target = (int)Math.ceil((double) sum /2);

        int[][] cache = new int[stones.length][target+1];
        for(int[] row : cache) Arrays.fill(row, -1);

        return dfs(stones, target, sum, 0, 0, cache);
    }

    private int dfs(int[] stones, int target, int sum, int total, int idx, int[][] cache){
        if(total >= target || idx >= stones.length) return Math.abs(total - (sum-total));
        if(cache[idx][total] != -1) return cache[idx][total];

        return cache[idx][total] = Math.min(dfs(stones, target, sum, total, idx+1, cache),
                                            dfs(stones, target, sum, total+stones[idx], idx+1, cache));
    }
}