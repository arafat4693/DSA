package DP;

import java.util.Arrays;

public class BurstBallons {
    public int maxCoins(int[] nums) {
        int[] numsArr = new int[nums.length + 2];
        numsArr[0] = 1;
        numsArr[numsArr.length-1] = 1;

        for(int i = 1; i < numsArr.length-1; i++) numsArr[i] = nums[i-1];

        int[][] cache = new int[numsArr.length][numsArr.length];
//        for(int[] row : cache) Arrays.fill(row, -1);
//        return dfs(numsArr, cache, 1, numsArr.length-2);

        for(int i = numsArr.length-2; i >= 1; i--){
            for(int j = 1; j <= numsArr.length-2; j++){
                int mxCoins = 0;

                for(int p = i; p <= j; p++){
                    int coins = (nums[i-1] * nums[p] * nums[j+1]) + cache[i][p-1] + cache[p+1][j];
                    mxCoins = Math.max(mxCoins, coins);
                }

                cache[i][j] = mxCoins;
            }
        }

        return cache[1][numsArr.length-2];
    }

    private int dfs(int[] nums, int[][] cache, int i, int j){
        if(cache[i][j] != -1) return cache[i][j];

        int mxCoins = 0;

        for(int p = i; p <= j; p++){
            int coins = (nums[i-1] * nums[p] * nums[j+1]) + dfs(nums, cache, i, p-1) + dfs(nums, cache, p+1, j);
            mxCoins = Math.max(mxCoins, coins);
        }

        return cache[i][j] = mxCoins;
    }
}
