package DP;

public class OnesAndZeroes {
    public int findMaxForm(String[] strs, int m, int n){
        int[][][] cache = new int[strs.length][m+1][n+1];

        return dfs(strs, m, n, 0, cache);
    }

    private int dfs(String[] s, int m, int n, int idx, int[][][] cache){
        if(idx >= s.length) return 0;
        if(m == 0 && n == 0) return 0;
        if(m < 0 || n < 0) return -1;

        if(cache[idx][m][n] != 0) return cache[idx][m][n];

        int one = 0, zero = 0;
        for(int i = 0; i < s[idx].length(); i++){
            if(s[idx].charAt(i) == '1') one++;
            else zero++;
        }

        int ans = 1 + dfs(s, m-zero, n-one, idx+1, cache);
        ans = Math.max(ans, dfs(s, m, n, idx+1, cache));

        return cache[idx][m][n] = ans;
    }
}
