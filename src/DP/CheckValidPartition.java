package DP;

import java.util.Arrays;

public class CheckValidPartition {
    public boolean validPartition(int[] nums) {
        int[] cache = new int[nums.length];
        Arrays.fill(cache, -1);
        return dfs(nums, 0, cache);
    }

    private boolean dfs(int[] nums, int idx, int[] cache){
        if(idx == nums.length) return true;
        if(cache[idx] != -1) return cache[idx] == 0 ? false : true;

        cache[idx] = 1;
        if(idx + 1 < nums.length && nums[idx+1] == nums[idx]) {
            if(dfs(nums, idx+2, cache)) return true;
        }

        if(idx + 2 < nums.length && nums[idx+1] == nums[idx] && nums[idx+2] == nums[idx]){
            if(dfs(nums, idx+3, cache)) return true;
        }

        if(idx + 2 < nums.length && nums[idx] == nums[idx+1]-1 && nums[idx] == nums[idx+2]-2){
            if(dfs(nums, idx+3, cache)) return true;
        }

        cache[idx] = 0;
        return false;
    }
}
