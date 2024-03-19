package DP;

public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] cache = new int[m][n];
        return dfs(0,0, cache);
    }

    private int dfs(int row, int col, int[][] cache){
        if(row >= cache.length || col >= cache[0].length) return 0;
        if(cache[row][col] != 0) return cache[row][col];
        if(row == cache.length-1 && col == cache[0].length-1 ) return 1;

        cache[row][col] = dfs(row+1, col, cache) + dfs(row, col+1, cache);
        return cache[row][col];
    }
}
