package DP;

public class LCS {
    public int longestCommonSubsequence(String text1, String text2) {
//        int[][] cache = new int[text1.length()][text2.length()];
//        for(int i = 0; i < text1.length(); i++){
//            for(int j = 0; j < text2.length(); j++) cache[i][j] = -1;
//        }
//        return dfs(text1, text2, 0, 0, cache);

        int[][] cache = new int[text1.length()+1][text2.length()+1];

        for(int idx1 = text1.length()-1; idx1 >= 0; idx1--){
            for(int idx2 = text2.length()-1; idx2 >= 0; idx2--){
                if(text1.charAt(idx1) == text2.charAt(idx2)){
                    cache[idx1][idx2] = 1 + cache[idx1+1][idx2+1];
                }else cache[idx1][idx2] = Math.max(cache[idx1+1][idx2], cache[idx1][idx2+1]);
            }
        }

        return cache[0][0];
    }

    private int dfs(String text1, String text2, int idx1, int idx2, int[][] cache){
        if(idx1 >= text1.length() || idx2 >= text2.length()) return 0;
        if(cache[idx1][idx2] != -1) return cache[idx1][idx2];

        if(text1.charAt(idx1) == text2.charAt(idx2)){
            cache[idx1][idx2] = 1 + dfs(text1, text2, idx1+1, idx2+1, cache);
        }else cache[idx1][idx2] = Math.max(dfs(text1, text2, idx1+1, idx2, cache), dfs(text1, text2, idx1, idx2+1, cache));

        return cache[idx1][idx2];
    }
}
