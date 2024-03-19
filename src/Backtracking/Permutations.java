package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, res, new ArrayList<>());
        return res;
    }

    private void dfs(int[] nums, List<List<Integer>> res, List<Integer> subList){
        if(subList.size() == nums.length){
            res.add(new ArrayList<>(subList));
            return;
        }

        for (int num : nums) {
            if (subList.contains(num)) continue;
            subList.add(num);
            dfs(nums, res, subList);
            subList.remove(subList.size() - 1);
        }
    }
}
