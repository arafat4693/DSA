package DP;

public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        int[][] cache = new int[grid.length][grid[0].length];
        return dfs(grid, 0, 0, cache);
    }

    private int dfs(int[][] grid, int row, int col, int[][] cache){
        if(row >= grid.length || col >= grid[0].length) return Integer.MAX_VALUE;
        if(row == grid.length - 1 && col == grid[0].length - 1) return grid[row][col];
        if(cache[row][col] != 0) return cache[row][col];

        return cache[row][col] = grid[row][col] + Math.min(dfs(grid, row+1, col, cache), dfs(grid, row, col+1, cache));
    }
}
