package DP;

import java.util.Arrays;

public class LongestStringChain {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b) -> a.length() - b.length());

        int n = words.length, mx = 0;

        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for(int i = n-1; i >= 0; i--){
            String pre = words[i];
            for(int j = i+1; j < n; j++){
                String next = words[j];

                if(next.length() - pre.length() == 1){
                    int p = 0, x = 0;
                    while(p < pre.length() && pre.charAt(p) == next.charAt(x)){
                        p++;
                        x++;
                    }

                    if(next.substring(x+1).equals(pre.substring(p))) dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }

            mx = Math.max(mx, dp[i]);
        }

        return mx;
    }
}
