package DP;

public class WildcardMatching {
    public boolean isMatch(String s, String p) {
//        int[][] cache = new int[s.length()][p.length()];
//        return dfs(s, p, cache, 0, 0) == 1;

        boolean[][] cache = new boolean[s.length()+1][p.length()+1];
        cache[s.length()][p.length()] = true;

        for(int i = 0; i < s.length(); i++) cache[i][p.length()] = false;

        for(int k = p.length()-1; k >= 0; k--){
            if(cache[s.length()][k+1] && p.charAt(k) == '*') cache[s.length()][k] = true;
            else break;
        }

        for(int i = s.length()-1; i >= 0; i--){
            for(int j = p.length()-1; j >= 0; j--){
                if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') return cache[i][j] = cache[i+1][j+1];
                if(p.charAt(j) == '*') cache[i][j] = cache[i][j+1] || cache[i+1][j];
            }
        }

        return cache[0][0];
    }

    private int dfs(String s, String p, int[][] cache, int i, int j){
        if(i >= s.length() && j >= p.length()) return 1;
        if(j >= p.length()) return -1;
        if(i >= s.length()) {
            for(int k = j; k < p.length(); k++){
                if(p.charAt(k) != '*') return -1;
            }
            return 1;
        }
        if(cache[i][j] != 0) return cache[i][j];

        if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') return cache[i][j] = dfs(s, p, cache, i+1, j+1);
        if(p.charAt(j) == '*'){
            cache[i][j] = dfs(s, p, cache, i, j+1);
            if(cache[i][j] == -1) cache[i][j] = dfs(s, p, cache, i+1, j);
            return cache[i][j];
        }

        return cache[i][j] = -1;
    }
}
