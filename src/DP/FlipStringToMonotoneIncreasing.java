package DP;

import java.util.Arrays;

public class FlipStringToMonotoneIncreasing {
    public int minFlipsMonoIncr(String s) {
//        int[][] cache = new int[s.length()][2];
//
//        for(int[] row : cache) Arrays.fill(row, -1);
//
//        return dfs(0, s.charAt(0) == '0', s, cache);

        int one = 0, res = 0;

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '1') one++;
            else res = Math.min(one, res+1);
        }

        return res;
    }

    private int dfs(int idx, boolean zero, String s, int[][] cache){
        if(idx >= s.length()) return 0;
        if(cache[idx][zero ? 1 : 0] != -1) return cache[idx][zero ? 1 : 0];

        int ans = Integer.MAX_VALUE;

        if(zero){
            // no flip
            ans = Math.min(dfs(idx+1, s.charAt(idx) == '0', s, cache), ans);

            //flip
            ans = Math.min(1+dfs(idx+1, !(s.charAt(idx) == '0'), s, cache), ans);
        }else{
            ans = Math.min((s.charAt(idx)=='1' ? 0 : 1)+dfs(idx+1, false, s, cache), ans);
        }

        return cache[idx][zero ? 1 : 0] = ans;
    }
}
