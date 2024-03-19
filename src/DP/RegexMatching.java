package DP;

public class RegexMatching {
    public boolean isMatch(String s, String p) {
        int[][] cache = new int[s.length()][p.length()];
        return dfs(s, p, cache, 0, 0) == 1;
    }

    private int dfs(String s, String p, int[][] cache, int i, int j){
        if(i >= s.length() && j >= p.length()) return 1;
        if(j >= p.length()) return -1;
        if(i >= s.length()){
            if((p.length() - j)%2 != 0) return -1;

            for(int k = j+1; k < p.length(); k+=2){
                if(p.charAt(k) != '*') return -1;
            }
            return 1;
        }
        if(cache[i][j] != 0) return cache[i][j];

        if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '.'){
            if(j+1 >= p.length() || p.charAt(j+1) != '*') return cache[i][j] = dfs(s, p, cache, i+1, j+1);
            cache[i][j] = dfs(s, p, cache, i, j+2);
            if(cache[i][j] == -1) cache[i][j] = dfs(s, p, cache, i+1, j);
            return cache[i][j];
        }

        if(j+1 >= p.length() || p.charAt(j+1) != '*') return cache[i][j] = -1;

        return cache[i][j] = dfs(s, p, cache, i, j+2);
    }
}
