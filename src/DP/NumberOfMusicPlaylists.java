package DP;

import java.util.Arrays;

public class NumberOfMusicPlaylists {
    private final int mod = 1000000007;
    public int numMusicPlaylists(int n, int goal, int k) {
        int[][] cache = new int[goal+1][n+1];
        for(int[] row : cache) Arrays.fill(row, -1);
        return dfs(n, goal, k, 0, cache);
    }

    private int dfs(int n, int goal, int k, int unique, int[][] cache){
        if(goal == 0){
            if(unique == n) return 1;
            return 0;
        }
        if(cache[goal][unique] != -1) return cache[goal][unique];

        long res = ((long) (n - unique) * dfs(n, goal-1, k, unique+1, cache)) % mod;
        if(unique > k) res += (long) (unique - k) * dfs(n, goal-1, k, unique, cache);
        return cache[goal][unique] = (int)(res % mod);
    }
}
