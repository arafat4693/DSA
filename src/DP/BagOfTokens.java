package DP;

import java.util.Arrays;

public class BagOfTokens {
    public int bagOfTokensScore(int[] tokens, int power) {
        int[][][] cache = new int[10001][tokens.length+1][1024];

        for(int[][] grid : cache){
            for(int[] row : grid) Arrays.fill(row, -1);
        }

        return solve(tokens, power, 0, 0, cache);
    }

    private int solve(int[] tokens, int power, int score, int mask, int[][][] cache){
        if(cache[power][score][mask] != -1) return cache[power][score][mask];

        int ans = score;

        for(int i = 0; i < tokens.length; i++){
            if((mask & (1 << i)) != 0) continue;

            int newMask = (mask | (1 << i));

            if(power >= tokens[i]){
                ans = Math.max(ans, solve(tokens, power - tokens[i], score+1, newMask, cache));
            }

            if(score >= 1){
                ans = Math.max(ans, solve(tokens, power + tokens[i], score-1, newMask, cache));
            }
        }

        return cache[power][score][mask] = ans;
    }
}
