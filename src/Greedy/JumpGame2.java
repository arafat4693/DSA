package Greedy;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class JumpGame2 {
    public int jump(int[] nums) {
//        int[] cache = new int[nums.length];
//        return dfs(nums, 0, cache);
        int res = 0, l = 0, r = 0;

        while(r < nums.length-1){
            int farthest = 0;
            for(int i = l; i <= r; i++){
                farthest = Math.max(farthest, i + nums[i]);
            }
            l = r+1;
            r = farthest;
            res++;
        }

        return res;
    }
    private int dfs(int[] nums, int idx,  int[] cache){
        if(idx == nums.length-1) return 0;
        if(idx >= nums.length) return Integer.MAX_VALUE;
        if(cache[idx] != 0) return cache[idx];

        int ans = Integer.MAX_VALUE;

        for(int i = 1; i <= nums[idx]; i++){
            ans = Math.min(ans, dfs(nums, idx+i, cache));
        }

        if(ans == Integer.MAX_VALUE) return cache[idx] = ans;
        return cache[idx] = 1+ans;
    }
}
