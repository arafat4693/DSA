package DP;

import java.sql.Array;
import java.util.Arrays;

public class PerfectSquares {
    public int numSquares(int n) {
        int[] cache = new int[n + 1];
//        return dfs(n, cache);
        Arrays.fill(cache, Integer.MAX_VALUE);
        cache[0] = 0;
        for(int k = 1; k <= n; k++){
            int ans = Integer.MAX_VALUE;
            for(int i = 1; i <= k; i++){
                if(i*i > k) break;
                ans = Math.min(ans, 1+dfs(k-(i*i), cache));
            }
            cache[k] = ans;
        }
        return cache[n];
    }

    private int dfs(int n, int[] cache){
        if(n == 0) return 0;
        if(cache[n] != 0) return cache[n];
        int ans = Integer.MAX_VALUE;
        for(int i = 1; i <= n; i++){
            if(i*i > n) break;
            ans = Math.min(ans, 1+dfs(n-(i*i), cache));
        }
        return cache[n] = ans;
    }
}
