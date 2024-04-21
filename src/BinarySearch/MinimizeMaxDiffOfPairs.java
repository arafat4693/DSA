package BinarySearch;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MinimizeMaxDiffOfPairs {
    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        int l = 0, r = 1000000000, res = Integer.MAX_VALUE;

        while(l <= r){
            int mid = (l+r)/2;
            int i = 0, pairs = 0;
            while(i < nums.length-1){
                if(Math.abs(nums[i] - nums[i+1]) <= mid){
                    pairs++;
                    i+=2;
                }else i++;
            }

            if(pairs >= p){
                res = Math.min(res, mid);
                r = mid-1;
            }else l = mid+1;
        }

        return res;
    }

//    private int dfs(int[] nums, int p, int idx, int[][] cache){
//        if(p == 0) return 0;
//        if(idx >= nums.length-1) return Integer.MAX_VALUE;
//        if(cache[idx][p] != -1) return cache[idx][p];
//
//        return cache[idx][p] = Math.min(dfs(nums, p, idx+1, cache), Math.max(Math.abs(nums[idx] - nums[idx+1]), dfs(nums, p-1, idx+2, cache)));
//    }
}
