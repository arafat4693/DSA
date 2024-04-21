package DP;

import java.util.Arrays;

public class LongestPalindromicSubsequence {
    public int longestPalindromeSubseq(String s) {
        int[][] cache = new int[s.length()][s.length()];

        for(int[] row : cache) Arrays.fill(row, -1);

        String sRev = new StringBuilder(s).reverse().toString();
        return dfs(s, sRev, 0, 0, cache);
    }

    private int dfs(String s1, String s2, int idx1, int idx2, int[][] cache){
        if(idx1 >= s1.length() || idx2 >= s2.length()) return 0;
        if(cache[idx1][idx2] != -1) return cache[idx1][idx2];

        int ans;
        if(s1.charAt(idx1) == s2.charAt(idx2)) ans = 1 + dfs(s1, s2, idx1+1, idx2+1, cache);
        else ans = Math.max(dfs(s1, s2, idx1+1, idx2, cache), dfs(s1, s2, idx1, idx2+1, cache));

        return cache[idx1][idx2] = ans;
    }
}
