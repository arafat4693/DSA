package DP;

import java.util.Arrays;

public class SplitArrayLargestSum {
    public int splitArray(int[] nums, int k) {
        int[][] cache = new int[nums.length][k+1];
        for(int[] row : cache) Arrays.fill(row, -1);
        return dfs(nums, k , 1, 0, cache);
    }

    private int dfs(int[] nums, int k, int bucket, int nIdx, int[][] cache){
        if(nIdx >= nums.length) return 0;
        if(bucket > k) return Integer.MAX_VALUE;
        if(cache[nIdx][bucket] != -1) return cache[nIdx][bucket];

        int ans = Integer.MAX_VALUE, sum = 0;

        for(int i = nIdx; i < nums.length - (k - bucket); i++){
            sum += nums[i];
            ans = Math.min(Math.max(sum, dfs(nums, k, bucket+1, i+1, cache)), ans);
        }

        return cache[nIdx][bucket] = ans;
    }
}
