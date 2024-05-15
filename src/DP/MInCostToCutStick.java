package DP;

import java.util.Arrays;

public class MInCostToCutStick {
    public int minCost(int n, int[] cuts) {
        int[][] cache = new int[cuts.length][cuts.length];

        Arrays.sort(cuts);
        return dfs(0, n, cuts, 0, cuts.length-1, cache);
    }

    private int dfs(int ns, int ne, int[] cuts, int s, int e, int[][] cache){
        if(s > e) return 0;
        if(cache[s][e] != 0) return cache[s][e];

        int ans = Integer.MAX_VALUE;

        for(int i = s; i <= e; i++){
            int res = dfs(ns, cuts[i], cuts, s, i-1, cache) + (ne-ns) + dfs(cuts[i], ne, cuts, i+1, e, cache);
            ans = Math.min(ans, res);
        }

        return cache[s][e] = ans;
    }
}
