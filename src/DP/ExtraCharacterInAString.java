package DP;

import java.util.Arrays;

public class ExtraCharacterInAString {
     public int minExtraChar(String s, String[] dictionary) {
         int[] cache = new int[s.length()];
         Arrays.fill(cache, -1);
         return dfs(s, dictionary, 0, cache);
     }

     private int dfs(String s, String[] dict, int idx, int[] cache){
         if(idx >= s.length()) return 0;
         if(cache[idx] != -1) return cache[idx];

         int count = 0, res = Integer.MAX_VALUE;

         for(int i = idx; i < s.length(); i++){
             for(String d : dict){
                 if(s.startsWith(d, i)){
                     res = Math.min(res, dfs(s, dict, d.length()+i, cache)+count);
                 }
             }
             count++;
         }

         return cache[idx] = res != Integer.MAX_VALUE ? res : s.length()-idx;
     }
}
