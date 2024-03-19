package DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LngstPalindromicSubStr {
    public String longestPalindrome(String s) {
        int[][][] cache = new int[s.length()][s.length()][2];

        for(int i = 0; i < s.length(); i++){
            for(int j = 0; j < s.length(); j++){
                cache[i][j] = new int[]{-1, -1};
            }
        }

        int[] ans = dfs(cache, s, 0, s.length()-1);
        return s.substring(ans[0], ans[1]+1);
    }

    private int[] dfs(int[][][] cache, String s, int l, int r){
        if(r-l == 0) {
            return cache[l][r] = new int[]{l, r};
        }

        if(r-l == 1){
            if(s.charAt(l) != s.charAt(r)){
                return cache[l][r] = new int[]{l, l};
            }
            return cache[l][r] = new int[]{l, r};
        }

        if(cache[l][r][0] != -1) return cache[l][r];

        int[] ans = dfs(cache, s, l+1, r-1);

        if(s.charAt(l) == s.charAt(r)){
            if(l+1 == ans[0] && r-1 == ans[1]) return cache[l][r] = new int[]{l, r};
            return cache[l][r] = ans;
        }

        return cache[l][r] = ans;
    }
}
