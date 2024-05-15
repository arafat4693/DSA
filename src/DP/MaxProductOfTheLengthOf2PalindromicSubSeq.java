package DP;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class MaxProductOfTheLengthOf2PalindromicSubSeq {
    int best = 0;
    public int maxProduct(String s) {
//        return dfs(s, new StringBuilder(), new StringBuilder(), 0);
        int n = s.length(), res = 0;
        HashMap<Integer, Integer> pali = new HashMap<>();

        for(int mask = 1; mask < (1 << n); mask++){
            StringBuilder str = new StringBuilder();
            for(int j = 0; j < n; j++){
                int v = mask & (1 << j);
                if(v == 0) continue;
                str.append(s.charAt(j));
            }

            String S = str.toString();
            if(S.compareTo(str.reverse().toString()) == 0) pali.put(mask, S.length());
        }

        for(int k1 : pali.keySet()){
            for(int k2 : pali.keySet()){
                if((k1 & k2) == 0) res = Math.max(res, pali.get(k1)*pali.get(k2));
            }
        }

        return res;
    }

    private int dfs(String s, StringBuilder s1, StringBuilder s2, int index){
        if(index >= s.length()){
            if(s1.length() * s2.length() > best){
                String r1 = new StringBuilder(s1).reverse().toString();
                String r2 = new StringBuilder(s2).reverse().toString();
                if(s1.toString().compareTo(r1) == 0 && s2.toString().compareTo(r2) == 0) best = s1.length()*s2.length();
            }
            return best;
        }

        int ans = dfs(s, s1, s2, index+1);

        s1.append(s.charAt(index));
        ans = Math.max(ans, dfs(s, s1, s2, index+1));
        s1.deleteCharAt(s1.length()-1);

        s2.append(s.charAt(index));
        ans = Math.max(ans, dfs(s, s1, s2, index+1));
        s2.deleteCharAt(s2.length()-1);

        return ans;
    }
}
