package DP;

import java.util.Arrays;
import java.util.List;

public class MaximumValueOfKCoinsFromPiles {
//    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
//        int mx = 0;
//        for(List<Integer> pile : piles) mx = Math.max(mx, pile.size());
//        int[][][] cache = new int[piles.size()][mx][k+1];
//        return dfs(piles, k, 0, 0, cache);
//    }
//
//    private int dfs(List<List<Integer>> piles, int k, int idx, int i, int[][][] cache){
//        if(idx >= piles.size() || i >= piles.get(idx).size() || k == 0) return 0;
//        if(cache[idx][i][k] != 0) return cache[idx][i][k];
//
//        List<Integer> pile = piles.get(idx);
//
//        int ans = Math.max(pile.get(i) + Math.max(dfs(piles, k-1, idx, i+1, cache),
//                        dfs(piles, k-1, idx+1, 0, cache)),
//                dfs(piles, k, idx+1, 0, cache));
//
//        return cache[idx][i][k] = ans;
//    }

    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        int[][] cache = new int[piles.size()][k+1];
        return dfs(piles, k, 0, cache);
    }

    private int dfs(List<List<Integer>> piles, int k, int idx, int[][] cache){
        if(idx >= piles.size() || k == 0) return 0;
        if(cache[idx][k] != 0) return cache[idx][k];

        List<Integer> pile = piles.get(idx);

        int res = dfs(piles, k, idx+1, cache);
        int sum = 0;
        for(int i = 0; i < Math.min(pile.size(), k); i++){
            sum += pile.get(i);
            res = Math.max(res, sum + dfs(piles, k-i-1, idx+1, cache));
        }

        return cache[idx][k] = res;
    }
}
