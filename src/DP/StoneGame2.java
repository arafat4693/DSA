package DP;

import java.util.Arrays;

public class StoneGame2 {
    public int stoneGameII(int[] piles) {
        int maxM = piles.length+1;

        int[][][] cache = new int[piles.length][maxM][2];

        for(int i = 0; i < piles.length; i++){
            for(int j = 0; j < maxM; j++){
                for(int k = 0; k < 2; k++){
                    cache[i][j][k] = -1;
                }
            }
        }

        return dfs(piles, 0, 1, 0, cache);
    }

    private int dfs(int[] piles, int idx, int m, int turn, int[][][] cache){
        if(idx >= piles.length) return 0;
        if(cache[idx][m][turn] != -1) return cache[idx][m][turn];

        int stone;
        int upperBound = Math.min(piles.length, idx+(m*2));

        if(turn == 0) { // Alice
            stone = Integer.MIN_VALUE;
            int collected = 0;
            for(int i = idx; i < upperBound; i++){
                collected += piles[i];
                stone = Math.max(stone, collected + dfs(piles, i+1, Math.max(i-idx+1, m), 1, cache));
            }
        }else{ // Bob
            stone = Integer.MAX_VALUE;
            for(int i = idx; i < upperBound; i++){
                stone = Math.min(stone, dfs(piles, i+1, Math.max(i-idx+1, m), 0, cache));
            }
        }

        return cache[idx][m][turn] = stone;
    }
}
