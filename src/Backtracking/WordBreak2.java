package Backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class WordBreak2 {
    List<String> res = new ArrayList<>();

    public List<String> wordBreak(String s, List<String> wordDict) {
        backtrack(s, wordDict, 0, new StringBuilder());
        return res;
    }

    private void backtrack(String s, List<String> wordDict, int idx, StringBuilder subRes){
        if(idx >= s.length()){
            StringBuilder copy = new StringBuilder(subRes);
            copy.deleteCharAt(copy.length()-1);
            res.add(copy.toString());
            return;
        }

        StringBuilder str = new StringBuilder();

        for(int i = idx; i < s.length(); i++){
            str.append(s.charAt(i));

            for(String word : wordDict){
                if(Objects.equals(word, str.toString())){
                    subRes.append(str).append(" ");
                    backtrack(s, wordDict, i+1, subRes);
                    subRes.delete(subRes.length()-(str.length()+1), subRes.length());
                    break;
                }
            }
        }

    }
}
