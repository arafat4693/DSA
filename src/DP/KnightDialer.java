package DP;

import java.util.Arrays;

public class KnightDialer {
    int mod = 1000000007;
    public int knightDialer(int n) {
        int[][][] cache = new int[4][3][n+1];
        for(int[][] a : cache){
            for(int[] b : a) Arrays.fill(b, -1);
        }

        long res = 0;

        for(int r = 0; r < 4; r++){
            for(int c = 0; c < 3; c++){
                res += solve(n-1, r, c, cache);
                res %= mod;
            }
        }

        return (int)res;
    }

    private int solve(int n, int r, int c, int[][][] cache){
        if(r < 0 || r >= 4 || c < 0 || c >= 3 || (r == 3 && (c == 0 || c == 2))) return 0;
        if(n == 0) return 1;
        if(cache[r][c][n] != -1) return cache[r][c][n];

        long ans = solve(n-1, r-2, c-1, cache);
        ans = (solve(n-1, r-2, c+1, cache) + ans) % mod;

        ans = (solve(n-1, r+2, c+1, cache) + ans) % mod;
        ans = (solve(n-1, r+2, c-1, cache) + ans) % mod;

        ans = (solve(n-1, r-1, c+2, cache) + ans) % mod;
        ans = (solve(n-1, r+1, c+2, cache) + ans) % mod;

        ans = (solve(n-1, r-1, c-2, cache) + ans) % mod;
        ans = (solve(n-1, r+1, c-2, cache) + ans) % mod;

        return cache[r][c][n] = (int)ans;
    }
}
