package DP;

import java.util.Arrays;

public class HouseRobber {
    public int rob(int[] nums) {
        int[] cache = new int[nums.length];
        Arrays.fill(cache, -1);
        return dfs(0, nums, cache);
//        if(nums.length == 1) return nums[0];
//
//        int[] dp = new int[nums.length];
//        dp[nums.length-1] = nums[nums.length-1];
//        dp[nums.length-2] = Math.max(nums[nums.length-1], nums[nums.length-2]);
//
//        for(int i = nums.length-3; i >= 0; i--){
//            dp[i] = Math.max(nums[i] + dp[i+2], dp[i+1]);
//        }
//        return dp[0], dp[1];
//        int one = Math.max(nums[nums.length-1], nums[nums.length-2]), two = nums[nums.length-1];
//        for(int i = nums.length-3; i >= 0; i--){
//            int tmp = one;
//            one = Math.max(nums[i] + two, one);
//            two = tmp;
//        }
//        return one, two;
    }

    private int dfs(int idx, int[] nums, int[] cache){
        if(idx >= nums.length) return 0;
        if(cache[idx] >= 0) return cache[idx];

        int res = Math.max(nums[idx] + dfs(idx+2, nums, cache), dfs(idx+1, nums, cache));
        cache[idx] = res;
        return res;
    }
}
