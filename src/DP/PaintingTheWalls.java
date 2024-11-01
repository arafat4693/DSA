package DP;

import java.util.Arrays;

public class PaintingTheWalls {
    public int paintWalls(int[] cost, int[] time) {
        int[][] cache = new int[cost.length][cost.length+1];
        for(int[] row : cache) Arrays.fill(row, -1);

        return dfs(cost, time, 0, 0, cache);
    }

    private int dfs(int[] cost, int[] time, int idx, int walls, int[][] cache){
        if(walls >= cost.length) return 0;
        if(idx == cost.length) return Integer.MAX_VALUE/2;

        if(cache[idx][walls] != -1) return cache[idx][walls];

        int ans = dfs(cost, time, idx+1, walls, cache);
        ans = Math.min(ans, cost[idx] + dfs(cost, time, idx+1, walls+time[idx]+1, cache));

        return cache[idx][walls] = ans;
    }
}
