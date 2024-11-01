package DP;

import java.util.Arrays;

public class New21Game {
    public double new21Game(int n, int k, int maxPts) {
//        double[] cache = new double[k+1];
//        Arrays.fill(cache, -1);
//
//        return solve(n, k, maxPts, 0, cache);

        double[] p = new double[n+1];
        p[0] = 1;
        double pSum = 1;

        for(int i = 1; i <= n; i++){
            p[i] = pSum / maxPts;

            if(i < k) pSum += p[i];

            if(i - maxPts >= 0 && i - maxPts < k) pSum -= p[i-maxPts];
        }

        double ans = 0;
        for(int i = k; i <= n; i++) ans += p[i];

        return ans;
    }

    private double solve(int n, int k, int maxPts, int curr, double[] cache){
        if(curr >= k) return curr <= n ? 1 : 0;
        if(cache[curr] != -1) return cache[curr];

        double ans = 0;

        for(int i = 1; i <= maxPts; i++){
            ans += (((double) 1 /maxPts) * solve(n, k, maxPts, curr+i, cache));
        }


        return cache[curr] = ans;
    }
}
