package DP;

import java.util.Arrays;
import java.util.HashMap;

public class NrOfWaysToFormAString {
    private final int mod = 1000000007;
    public int numWays(String[] words, String target) {
        int wl = words[0].length();

        int[][] cache = new int[wl][target.length()];
        for(int[] row : cache) Arrays.fill(row, -1);

        HashMap<Character, Integer>[] freq = new HashMap[wl];

        int idx = 0;

        for(int i = 0; i < wl; i++){
            freq[i] = new HashMap<>();
            for(String word : words){
                freq[i].put(word.charAt(i), freq[i].getOrDefault(word.charAt(i), 0)+1);
            }
            if(idx != target.length()){
                if(freq[i].containsKey(target.charAt(idx))) idx++;
            }
        }

        if(idx != target.length()) return 0;

        return dfs(wl, target, 0, 0, cache, freq);
    }

    private int dfs(int wl, String target, int idx, int length, int[][] cache, HashMap<Character, Integer>[] freq){
        if(length == target.length()) return 1;
        if(wl-idx < target.length()-length) return 0;
        if(cache[idx][length] != -1) return cache[idx][length];

        long res;

//        for(int j = idx; j < wl; j++){
//            if(freq[j].containsKey(target.charAt(length))){
//                res += (long) freq[j].get(target.charAt(length)) * dfs(wl, target, j+1, length+1, cache, freq);
//                res %= mod;
//            }
//        }

        res = dfs(wl, target, idx+1, length, cache, freq)%mod;
        if(freq[idx].containsKey(target.charAt(length))){
            res += (long) freq[idx].get(target.charAt(length)) * dfs(wl, target, idx+1, length+1, cache, freq);
        }

        return cache[idx][length] = (int)(res%mod);
    }
}
