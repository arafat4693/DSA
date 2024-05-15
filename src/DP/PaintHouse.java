package DP;

import java.util.Arrays;

public class PaintHouse {
    public int minCost(int[][] costs) {
        int[][] cache = new int[costs.length][4];
        for(int[] row : cache) Arrays.fill(row, -1);

        return dfs(costs, -1, 0, cache);
    }

    private int dfs(int[][] costs, int prev, int idx, int[][] cache){
        if(idx >= costs.length) return 0;
        if(cache[idx][prev+1] != -1) return cache[idx][prev+1];

        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < 3; i++){
            if(i == prev) continue;
            ans = Math.min(ans, costs[idx][i] + dfs(costs, i, idx+1, cache));
        }

        return cache[idx][prev+1] = ans;
    }
}
