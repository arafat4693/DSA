package DP;

import java.util.HashSet;

public class UniqueBSTs {
    public int numTrees(int n) {
        int[] cache = new int[n+1];
        return dfs(n, cache);
    }

    public int dfs(int n, int[] cache) {
        if(n <= 1) return 1;
        if(cache[n] != 0) return cache[n];

        int ans = 0;

        for(int i = 1; i <= n; i++){
            int left = numTrees(i-1);
            int right = numTrees(n-i);

            ans += left*right;
        }

        return cache[n] = ans;
    }
}
