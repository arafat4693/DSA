package DP;

public class InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s3.length() != (s1.length() + s2.length())) return false;
//        int[][] cache = new int[s1.length()+1][s2.length()+1];
//        return dfs(s1, s2, s3, 0, 0, cache) == 1;

        boolean[][] cache = new boolean[s1.length()+1][s2.length()+1];

        cache[s1.length()][s2.length()] = true;

        for(int i = s2.length()-1; i >= 0; i--){
            cache[s1.length()][i] = s2.charAt(i) == s3.charAt(s1.length() + i) && cache[s1.length()][i + 1];
        }

        for(int i = s1.length()-1; i >= 0; i--){
            cache[i][s2.length()] = s1.charAt(i) == s3.charAt(s2.length() + i) && cache[i+1][s2.length()];
        }

        for(int s1Idx = s1.length()-1; s1Idx >= 0; s1Idx--){
            for(int s2Idx = s2.length()-1; s2Idx >= 0; s2Idx--){
                if(s1.charAt(s1Idx) == s3.charAt(s1Idx+s2Idx) && cache[s1Idx+1][s2Idx]){
                    cache[s1Idx][s2Idx] = true;
                    continue;
                }
                if(s2.charAt(s2Idx) == s3.charAt(s1Idx+s2Idx) && cache[s1Idx][s2Idx+1]){
                    cache[s1Idx][s2Idx] = true;
                    continue;
                }

                cache[s1Idx][s2Idx] = false;
            }
        }

        return cache[0][0];
    }

    private int dfs(String s1, String s2, String s3, int s1Idx, int s2Idx, int[][] cache){
        if(s1Idx + s2Idx == s3.length()) return 1;
        if(cache[s1Idx][s2Idx] != 0) return cache[s1Idx][s2Idx];

        if(s1Idx < s1.length() && s1.charAt(s1Idx) == s3.charAt(s1Idx+s2Idx)){
            int ans = dfs(s1, s2, s3, s1Idx+1, s2Idx, cache);
            if(ans == 1) return cache[s1Idx][s2Idx] = 1;
        }
        if(s2Idx < s2.length() && s2.charAt(s2Idx) == s3.charAt(s1Idx+s2Idx)){
            int ans = dfs(s1, s2, s3, s1Idx, s2Idx+1, cache);
            if(ans == 1) return cache[s1Idx][s2Idx] = 1;
        }

        return cache[s1Idx][s2Idx] = -1;
    }
}
