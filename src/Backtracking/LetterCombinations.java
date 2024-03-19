package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinations {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits.isEmpty()) return res;
        String[] dMapping = new String[]{"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        dfs(digits, 0, new StringBuilder(), res, dMapping);
        return res;
    }

    private void dfs(String digits, int index, StringBuilder subRes, List<String> res, String[] dMapping){
        if(index >= digits.length()){
            res.add(subRes.toString());
            return;
        }
        String s = dMapping[digits.charAt(index) - '2'];
        for(int i = 0; i < s.length(); i++){
            subRes.append(s.charAt(i));
            dfs(digits, index + 1, subRes, res, dMapping);
            subRes.deleteCharAt(subRes.length() - 1);
        }
    }
}
