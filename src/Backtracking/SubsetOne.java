package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetOne {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(0, nums, new ArrayList<>(), res);
        return res;
    }

    private void dfs(int idx, int[] nums, List<Integer> subset, List<List<Integer>> res){
        if(idx >= nums.length){
            res.add(new ArrayList<>(subset));
            return;
        }
        subset.add(nums[idx]);
        dfs(idx+1, nums, subset, res);

        subset.remove(subset.size()-1);
        dfs(idx+1, nums, subset, res);
    }
}
