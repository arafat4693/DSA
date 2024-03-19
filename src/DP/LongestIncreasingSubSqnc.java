package DP;

import java.util.Arrays;

public class LongestIncreasingSubSqnc {
    int mx = 1;
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 1) return 1;

        int[][] cache = new int[nums.length][nums.length+1];
        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < nums.length+1; j++) cache[i][j] = -1;
        }
        return dfs(cache, nums, 0, -1);
//        System.out.println(Arrays.toString(cache));
//        return mx;

//        int[] cache = new int[nums.length];
//        Arrays.fill(cache, 1);
//
//        int mxSoFar = 1;
//
//        for(int i = nums.length-1; i >= 0; i--){
//            for(int j = i+1; j < nums.length; j++){
//                if(nums[i] < nums[j]) cache[i] = Math.max(cache[i], 1+cache[j]);
//            }
//            mxSoFar = Math.max(mxSoFar, cache[i]);
//        }
//
//        return mxSoFar;
    }

//    private int dfs(int[] cache, int[] nums, int idx){
//        if(cache[idx] != 0) return cache[idx];
//
//        for(int j = idx+1; j < nums.length; j++){
//            int ans = dfs(cache, nums, j);
//            if(nums[idx] < nums[j]) cache[idx] = Math.max(cache[idx], 1 + ans);
//        }
//
//        mx = Math.max(mx, cache[idx]);
//
//        return cache[idx] == 0 ? cache[idx] = 1 : cache[idx];
//    }
    private int dfs(int[][] cache, int[] nums, int idx, int prevIdx){
        if(idx >= nums.length) return 0;
        if(cache[idx][prevIdx+1] != -1) return cache[idx][prevIdx+1];

        int ans = dfs(cache, nums, idx+1, prevIdx);
        if(prevIdx == -1 || nums[idx] > nums[prevIdx]){
            ans = Math.max(ans, 1+dfs(cache, nums, idx+1, idx));
        }
        return cache[idx][prevIdx+1] = ans;
    }
}
