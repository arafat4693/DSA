package Backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Permutations2 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), new HashSet<>(), new HashSet<>(), nums);
        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> subRes, HashSet<String> seen, HashSet<Integer> idx, int[] nums){
        if(idx.size() == nums.length){
            StringBuilder s = new StringBuilder();
            for(int r : subRes) s.append(r);
            if(!seen.add(s.toString())) return;
            res.add(new ArrayList<>(subRes));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(idx.contains(i)) continue;
            idx.add(i);
            subRes.add(nums[i]);
            backtrack(res, subRes, seen, idx, nums);
            idx.remove(i);
            subRes.remove(subRes.size()-1);
        }
    }
}
