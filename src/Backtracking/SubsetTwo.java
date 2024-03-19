package Backtracking;

import java.util.*;

public class SubsetTwo {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        dfs(0, nums, res, new ArrayList<>());
        return res;
    }

    private void dfs(int idx, int[] nums, List<List<Integer>> res, List<Integer> subRes){
        if(idx >= nums.length){
            res.add(new ArrayList<>(subRes));
            return;
        }

        subRes.add(nums[idx]);
        dfs(idx+1, nums, res, subRes);

        int num = subRes.remove(subRes.size() - 1);
        for(int i = idx; i < nums.length; i++){
            if(nums[i] == num) idx++;
            else break;
        }
        dfs(idx, nums, res, subRes);
    }
}
