package DP;

import java.util.Arrays;

public class LongestTurbulentSubArr {
    public int maxTurbulenceSize(int[] arr) {
        int[][] cache = new int[arr.length][3];

        for(int[] r: cache){
            Arrays.fill(r, -1);
        }

        int res = 0;
        for(int i = 0; i < arr.length; i++){
            res = Math.max(res, dfs(arr, i, 0, cache));
        }
        return res;
    }

    private int dfs(int[] arr, int i, int sign, int[][] cache){
        if(cache[i][sign] != -1) return cache[i][sign];

        int ans = 1;

        if(sign == 0){
            if(i+1 < arr.length && arr[i+1] != arr[i]){
                int s = arr[i+1] > arr[i] ? 2 : 1;
                ans = Math.max(ans, 1 + dfs(arr, i+1, s, cache));
            }
        }else{
            if(i+1 < arr.length && arr[i+1] != arr[i]){
                int s = arr[i+1] > arr[i] ? 2 : 1;
                if(s != sign) ans = Math.max(ans, 1 + dfs(arr, i+1, s, cache));
            }
        }

        return cache[i][sign] = ans;
    }
}
