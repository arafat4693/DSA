package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumTwo {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        dfs(candidates, target, res, new ArrayList<>(), 0);
        return res;
    }

    private void dfs(int[] candidates, int target, List<List<Integer>> res, List<Integer> subRes, int idx){
        if(target == 0){
            res.add(new ArrayList<>(subRes));
            return;
        }

        if(target < 0 || idx >= candidates.length) return;

        subRes.add(candidates[idx]);
        dfs(candidates, target - candidates[idx], res, subRes, idx+1);

        int num = subRes.remove(subRes.size() - 1);
        for(int i = idx; i < candidates.length; i++){
            if(candidates[i] == num) idx++;
            else break;
        }

        dfs(candidates, target, res, subRes, idx);
    }
}
