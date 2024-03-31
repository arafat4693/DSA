package DP;

import java.util.Arrays;

public class StoneGame {
    public boolean stoneGame(int[] piles) {
        int[][] cache = new int[piles.length][piles.length];
        for(int[] row : cache) Arrays.fill(row, -1);
        return dfs(piles, 0, piles.length-1, 0, cache) > 0;
    }

    private int dfs(int[] piles, int l, int r, int turn, int[][] cache){
        if(l > r) return 0;
        if(cache[l][r] != -1) return cache[l][r];

        int stones = 0;

        if(turn == 0){ // Alice
            stones = Math.max(piles[l] + dfs(piles, l+1, r, 1, cache), piles[r] + dfs(piles, l, r-1, 1, cache));
        }else { // bob
            stones = Math.min(-piles[l] + dfs(piles, l+1, r, 0, cache), -piles[r] + dfs(piles, l, r-1, 0, cache));
        }

        return cache[l][r] = stones;
    }
}
