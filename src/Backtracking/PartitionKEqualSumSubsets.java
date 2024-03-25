package Backtracking;

import java.util.Arrays;

public class PartitionKEqualSumSubsets {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = Arrays.stream(nums).sum();
        if(sum % k != 0) return false;

        int target = sum / k;
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        return dfs(nums, 0, target, k, 0);
    }

    private boolean dfs(int[] nums, int idx, int target, int k, int subTarget){
        if(k == 0) return true;
        if(target == subTarget) return dfs(nums, 0, target, k-1, 0);

//        if(idx >= nums.length) return false;
//
//        if(nums[idx] != -1){
//            int tmp = nums[idx];
//            if(subTarget+tmp > target) return false;
//            nums[idx] = -1;
//            if(dfs(nums, idx+1, target, k, subTarget+tmp)){
//                return true;
//            }
//            nums[idx] = tmp;
//        }
//        return dfs(nums, idx+1, target, k, subTarget);

        for(int i = idx; i < nums.length; i++){
            int tmp = nums[i];
            if(tmp == -1) continue;
            if(subTarget+tmp > target) return false;
            nums[i] = -1;
            if(dfs(nums, i+1, target, k, subTarget+tmp)) return true;
            nums[i] = tmp;
        }
        return false;
    }

}
