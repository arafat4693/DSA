package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(target, new ArrayList<>(), res, 0, candidates);
        return res;
    }

    private void dfs(int target, List<Integer> subList, List<List<Integer>> res, int idx, int[] candidates){
        if(target == 0){
            res.add(new ArrayList<>(subList));
            return;
        }

        if(target < 0 || idx >= candidates.length) return;

        subList.add(candidates[idx]);
        dfs(target - candidates[idx], subList, res, idx, candidates);

        subList.remove(subList.size() - 1);
        dfs(target, subList, res, idx+1, candidates);
    }
}
