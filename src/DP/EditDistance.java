package DP;

public class EditDistance {
    public int minDistance(String word1, String word2) {
//        int[][] cache = new int[word1.length()][word2.length()];
//        for(int i = 0; i < word1.length(); i++){
//            for(int j = 0; j < word2.length(); j++) cache[i][j] = -1;
//        }
//        return dfs(word1, word2, cache, 0, 0);

        int[][] cache = new int[word1.length()+1][word2.length()+1];

        for(int i = 0; i < word1.length()+1; i++){
            cache[i][word2.length()] = word1.length() - i;
        }

        for(int i = 0; i < word2.length()+1; i++){
            cache[word1.length()][i] = word2.length() - i;
        }

        for(int w1Idx = word1.length()-1; w1Idx >= 0; w1Idx--){
            for(int w2Idx = word2.length()-1; w2Idx >= 0; w2Idx--) {

                int ans = Integer.MAX_VALUE;

                if(word1.charAt(w1Idx) == word2.charAt(w2Idx))
                    ans = Math.min(ans, cache[w1Idx+1][w2Idx+1]); // same
                else {
                    ans = Math.min(ans, 1+cache[w1Idx][w2Idx+1]); // insert
                    ans = Math.min(ans, 1+cache[w1Idx+1][w2Idx]); // delete
                    ans = Math.min(ans, 1+cache[w1Idx+1][w2Idx+1]); // replace
                }

                cache[w1Idx][w2Idx] = ans;

            }
        }

        return cache[0][0];
    }

    private int dfs(String word1, String word2, int[][] cache, int w1Idx, int w2Idx){
        if(w2Idx >= word2.length()) return word1.length() - w1Idx;
        if(w1Idx >= word1.length()) return word2.length() - w2Idx;
        if(cache[w1Idx][w2Idx] != -1) return cache[w1Idx][w2Idx];

        int ans = Integer.MAX_VALUE;

        if(word1.charAt(w1Idx) == word2.charAt(w2Idx))
            ans = Math.min(ans, dfs(word1, word2, cache, w1Idx+1, w2Idx+1)); // same
        else {
            ans = Math.min(ans, 1+dfs(word1, word2, cache, w1Idx, w2Idx+1)); // insert
            ans = Math.min(ans, 1+dfs(word1, word2, cache, w1Idx+1, w2Idx)); // delete
            ans = Math.min(ans, 1+dfs(word1, word2, cache, w1Idx+1, w2Idx+1)); // replace
        }

        return cache[w1Idx][w2Idx] = ans;
    }
}
