package Greedy;

public class JumpGame {
    public boolean canJump(int[] nums) {
//        int[] cache = new int[nums.length];
//        return dfs(nums, 0, cache) == 1;
        int goal = nums.length - 1;
        for(int i = nums.length-2; i >= 0; i--){
            if(nums[i] == 0) continue;
            if(i + nums[i] >= goal) goal = i;
        }
        return goal == 0;
    }

    private int dfs(int[] nums, int idx, int[] cache){
        if(idx == nums.length-1) return 1;
        if(idx >= nums.length) return -1;
        if(cache[idx] != 0) return cache[idx];

        for(int i = 1; i <= nums[idx]; i++){
            if(dfs(nums, idx+i, cache) == 1) return cache[idx] = 1;
        }

        return cache[idx] = -1;
    }
}
