package DP;

import java.util.Arrays;

public class StringCompression2 {
    public int getLengthOfOptimalCompression(String s, int k) {
        int[][][][] cache = new int[k+1][s.length()][26][101];

        for (int i = 0; i <= k; i++) {
            for (int j = 0; j < s.length(); j++) {
                for (int l = 0; l < 26; l++) {
                    for (int m = 0; m < 101; m++) {
                        cache[i][j][l][m] = -1;
                    }
                }
            }
        }

        return dfs(s, k, 0, s.charAt(0), 0, cache);
    }

    private int dfs(String s, int k, int idx, char prev, int freq, int[][][][] cache){
        if(idx == s.length()) return 0;
        if(cache[k][idx][prev-'a'][freq] != -1) return cache[k][idx][prev-'a'][freq];

        int ans = Integer.MAX_VALUE;

        if(k > 0){
            ans = Math.min(ans, dfs(s, k-1, idx+1, prev, freq, cache)); // delete
        }

        // keep
        if(prev != s.charAt(idx)){
            ans = Math.min(ans, 1 + dfs(s, k, idx+1, s.charAt(idx), 1, cache));
        }else {
            int add = 0;
            if(freq == 0 || freq == 1 || freq == 9 || freq == 99) add = 1;
            ans = Math.min(ans, add + dfs(s, k, idx+1, prev, freq+1, cache));
        }

        return cache[k][idx][prev-'a'][freq] = ans;
    }
}
