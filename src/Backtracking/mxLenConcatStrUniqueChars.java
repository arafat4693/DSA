package Backtracking;

import java.util.HashSet;
import java.util.List;

public class mxLenConcatStrUniqueChars {
    int output = 0;

    public int maxLength(List<String> arr) {
        dfs(arr, 0, new StringBuilder());
        return output;
    }

    private void dfs(List<String> arr, int idx, StringBuilder res){
        if(idx >= arr.size()){
            HashSet<Character> hs = new HashSet<>();
            for(int i = 0; i < res.length(); i++){
                if(!hs.add(res.charAt(i))) return;
            }
            output = Math.max(output, res.length());
            return;
        }

        res.append(arr.get(idx));
        dfs(arr, idx+1, res);
        res.delete(res.length()-arr.get(idx).length(), res.length());
        dfs(arr, idx+1, res);
    }

}
