package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(n, k, res, new ArrayList<>(), 1);
        return res;
    }

    private void backtrack(int n, int k, List<List<Integer>> res, List<Integer> subRes, int idx){
        if(subRes.size() == k){
            res.add(new ArrayList<>(subRes));
            return;
        }

        for(int i = idx; i <= n; i++){
            subRes.add(i);
            backtrack(n, k, res, subRes, i+1);
            subRes.remove(subRes.size()-1);
        }

//        subRes.add(idx);
//        backtrack(n, k, res, subRes, idx+1);
//        subRes.remove(subRes.size()-1);
//        backtrack(n, k, res, subRes, idx+1);
    }
}
