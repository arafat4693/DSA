package DP;

public class DecodeWays {
    public int numDecodings(String s) {
//        int[] cache = new int[s.length()];
//        return dfs(s, cache, 0);

        int one = s.charAt(s.length() - 1) == '0' ? 0 : 1, two = 1;
        for(int i = s.length() - 2; i >= 0; i--){
            if(s.charAt(i) == '0'){
                if(i == 0) return 0;
                if(s.charAt(i-1) != '2' && s.charAt(i-1) != '1') return 0;
            }

            int tmp = one;
            if(s.charAt(i) == '0') one = 0;
            if(s.charAt(i) != '0' && Integer.parseInt(s.substring(i, i+2)) <= 26) one += two;
            two = tmp;
        }
        return one;
    }

    private int dfs(String s, int[] cache, int idx){
        if(idx == s.length()) return 1;
        if(s.charAt(idx) == '0') return 0;
        if(cache[idx] != 0) return cache[idx];

        int ways = dfs(s, cache, idx+1);
        if((idx + 1 < s.length()) && Integer.parseInt(s.substring(idx, idx+2)) <= 26) ways += dfs(s, cache, idx+2);
        cache[idx] = ways;
        return ways;
    }
}
