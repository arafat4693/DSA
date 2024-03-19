package DP;

public class TargetSum {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = getSum(nums);
        int[][] cache = new int[nums.length][sum * 2 + 1];

        for(int i = 0; i < nums.length; i++){
            for(int j = 1; j < cache[0].length; j++) cache[i][j] = -1;
        }

        return dfs(0, target, nums, cache, sum);
    }

    private int dfs(int idx, int target, int[] nums, int[][] cache, int sum){
        if(idx >= nums.length){
            if(target == 0) return 1;
            return 0;
        }
//         if(cache[idx][target + sum] != -1) return cache[idx][target + sum];

        int ans = dfs(idx+1, target - nums[idx], nums, cache, sum); // +
        ans += dfs(idx+1, target + nums[idx], nums, cache, sum); // -

        return ans;
//         return cache[idx][target + sum] = ans;
    }

    private int getSum(int[] nums){
        int s = 0;
        for(int n : nums) s += n;
        return s;
    }
}
