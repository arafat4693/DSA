package DP;

import java.util.Arrays;

public class OutOfBoundaryPaths {
    int mod = 1000000007;

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int[][][] cache = new int[m][n][maxMove+1];

        for(int[][] two : cache){
            for(int[] one : two) Arrays.fill(one, -1);
        }

        return dfs(m, n, maxMove, startRow, startColumn, cache);
    }

    private int dfs(int m, int n, int maxMove, int row, int col, int[][][] cache){
        if(row < 0 || row == m || col < 0 || col == n) return 1;
        if(maxMove == 0) return 0;
        if(cache[row][col][maxMove] != -1) return cache[row][col][maxMove];

        long ans = dfs(m, n, maxMove-1, row+1, col, cache);
        ans += dfs(m, n, maxMove-1, row-1, col, cache);
        ans += dfs(m, n, maxMove-1, row, col+1, cache);
        ans += dfs(m, n, maxMove-1, row, col-1, cache);

        return cache[row][col][maxMove] = (int)(ans%mod);
    }
}
