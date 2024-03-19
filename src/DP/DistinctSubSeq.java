package DP;

public class DistinctSubSeq {
    public int numDistinct(String s, String t) {
//        int[][] cache = new int[s.length()][t.length()];
//
//        for(int i = 0; i < s.length(); i++){
//            for(int j = 0; j < t.length(); j++) cache[i][j] = -1;
//        }

//        return dfs(s, t, cache, 0, 0);

        int[][] cache = new int[s.length()+1][t.length()+1];

        for(int i = 0; i < s.length()+1; i++){
            cache[i][t.length()] = 1;
        }

        for(int sIdx = s.length()-1; sIdx >= 0; sIdx--){
            for(int tIdx = t.length()-1; tIdx >= 0; tIdx--){
                cache[sIdx][tIdx] = cache[sIdx+1][tIdx];
                if(s.charAt(sIdx) == t.charAt(tIdx)){
                    cache[sIdx][tIdx] += cache[sIdx+1][tIdx+1];
                }
            }
        }

        return cache[0][0];
    }

    private int dfs(String s, String t, int[][] cache, int sIdx, int tIdx){
        if(tIdx >= t.length()) return 1;
        if(sIdx >= s.length()) return 0;
        if(cache[sIdx][tIdx] != -1) return cache[sIdx][tIdx];

        cache[sIdx][tIdx] = dfs(s, t, cache, sIdx+1, tIdx);
        if(s.charAt(sIdx) == t.charAt(tIdx)){
            cache[sIdx][tIdx] += dfs(s, t, cache, sIdx+1, tIdx+1);
        }

        return cache[sIdx][tIdx];
    }
}
