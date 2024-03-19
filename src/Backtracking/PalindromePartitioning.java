package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        dfs(s, 0, new ArrayList<>(), res);
        return res;
    }

    private void dfs(String s, int idx, List<String> subRes, List<List<String>> res){
        if(idx >= s.length()){
            res.add(new ArrayList<>(subRes));
            return;
        }

        for ( int i = idx; i < s.length(); i++ ){
            if(isPalindrome(s, idx, i)){
                subRes.add(s.substring(idx, i+1));
                dfs(s, i+1, subRes, res);
                subRes.remove(subRes.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int l, int r){
        while(l < r){
            if(s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}
