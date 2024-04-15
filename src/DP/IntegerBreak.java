package DP;

public class IntegerBreak {
    public int integerBreak(int n) {
        int[] cache = new int[n+1];
        return dfs(n, cache);
    }

//    private int dfs(int n, int org, int[] cache){
//        if(n == 1) return 1;
//        if(cache[n] != 0) return cache[n];
//
//        int ans = n == org ? 0 : n;
//
//        for(int i = 1; i < n; i++){
//            ans = Math.max(ans, dfs(i, org, cache) * dfs(n-i, org, cache));
//        }
//
//        return cache[n] = ans;
//    }

    private int dfs(int n, int[] cache){
        if(n == 1) return 1;
        if(cache[n] != 0) return cache[n];

        int ans = 0;

        for(int i = 1; i < n; i++){
            ans = Math.max(ans, i*Math.max(dfs(n-i, cache), n-i));
        }

        return cache[n] = ans;
    }
}
