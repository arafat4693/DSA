package DP;

import java.util.Arrays;

public class MaximumAltSubSeqSum {
    public long maxAlternatingSum(int[] nums) {
        long[][] cache = new long[nums.length][2];
        for(long[] row : cache) Arrays.fill(row, -1);
        return dfs(nums, 0, 0, cache);

//        long[][] cache = new long[nums.length+1][2];
//
//        for(int i = nums.length-1; i >= 0; i--){
//            for(int p = 1; p >= 0; p--){
//                cache[i][p] = Math.max(cache[i+1][p], cache[i+1][p == 0 ? 1 : 0] + (p == 0 ? nums[i] : -nums[i]));
//            }
//        }
//
//        return cache[0][0];

//        long[] dp = new long[2];
//
//        for(int i = nums.length-1; i >= 0; i--){
//            long[] d = new long[2];
//            for(int p = 1; p >= 0; p--){
//                d[p] = Math.max(dp[p], dp[p == 0 ? 1 : 0] + (p == 0 ? nums[i] : -nums[i]));
//            }
//            dp = d;
//        }
//
//        return dp[0];
    }

    private long dfs(int[] nums, int i, int p, long[][] cache){
        if(i >= nums.length) return 0;
        if(cache[i][p] != -1) return cache[i][p];
        long ans = dfs(nums, i+1, p, cache);
        ans = Math.max(ans, dfs(nums, i+1, p == 0 ? 1 : 0, cache) + (p == 0 ? nums[i] : -nums[i]));
        return cache[i][p] = ans;
    }
}
