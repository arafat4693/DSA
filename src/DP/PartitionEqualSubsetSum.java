package DP;

import java.util.Arrays;
import java.util.HashSet;

public class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        for(int n:nums) totalSum+=n;

        if(totalSum % 2 == 1) return false;

        int target = totalSum / 2;

//        HashSet<Integer> sums = new HashSet<>();
//        sums.add(0);
//        HashSet<Integer> sumsCpy = new HashSet<>(sums);
//
//        for(int i = nums.length-1; i >= 0; i--){
//            if(nums[i] == target) return true;
//            for(Integer s : sums){
//                if((nums[i] + s) == target) return true;
//                sumsCpy.add(nums[i] + s);
//            }
//            sums.addAll(sumsCpy);
//        }
//
//        return false;

//        int[][] cache = new int[nums.length][target+1];
//        return dfs(0, target, nums, cache) == 1;

        int[][] cache = new int[nums.length+1][target+1];

        cache[0][0] = 1;

        for(int i = 1; i <= nums.length; i++){
            for(int j = 1; j <= target; j++){
                if((j - nums[i-1] >= 0) && cache[i-1][j - nums[i-1]] == 1) cache[i][j] = 1;
                else if(cache[i-1][j] == 1) cache[i][j] = 1;
                else cache[i][j] = -1;
            }
        }

        return cache[nums.length][target] == 1;
    }

    private int dfs(int idx, int target, int[] nums, int[][] cache){
        if(target == 0) return 1;
        if(idx >= nums.length || target < 0) return -1;
        if(cache[idx][target] != 0) return cache[idx][target];

        if(dfs(idx+1, target - nums[idx], nums, cache) == 1) cache[idx][target] = 1;
        else if(dfs(idx+1, target, nums, cache) == 1) cache[idx][target] = 1;
        else cache[idx][target] = -1;

        return cache[idx][target];
    }
}
