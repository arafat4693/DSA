package DP;

import java.util.Arrays;

public class HouseRobber2 {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];

        int[] cache = new int[nums.length];
        Arrays.fill(cache, -1);

        int dfs1 = dfs(nums.length-1, 0, nums, cache);
        Arrays.fill(cache, -1);
        int dfs2 = dfs(nums.length, 1, nums, cache);

        return Math.max(dfs1, dfs2);
    }

    private int dfs(int n, int idx, int[] nums, int[] cache){
        if(idx >= n) return 0;
        if(cache[idx] >= 0) return cache[idx];

        int res = Math.max(dfs(n, idx+2, nums, cache) + nums[idx], dfs(n, idx+1, nums, cache));
        cache[idx] = res;
        return res;
    }
}
