package DP;

public class ClimbingStairs {
    public int climbStairs(int n) {
//        int[] cache = new int[n+1];
//        return dfs(n, cache, 0);
        int one = 1, two = 1;

        for(int i = 0; i < n-1; i++){
            int tmp = one;
            one = one + two;
            two = tmp;
        }

        return one;
    }

    private int dfs(int n, int[] cache, int f){
        if(f == n) return 1;
        if(f > n) return 0;
        if(cache[f] != 0) return cache[f];

        int res = dfs(n, cache, f+1) + dfs(n, cache, f+2);
        cache[f] = res;
        return res;
    }
}
