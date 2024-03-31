package DP;

import java.util.Arrays;

public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        int[][] cache = new int[matrix.length][matrix[0].length];
        for(int[] row : cache) Arrays.fill(row, -1);

        int mx = 0;

        for(int row = 0; row < matrix.length; row++){
            for(int col = 0; col < matrix[0].length; col++){
                int ans = dfs(matrix, cache, row, col);
                mx = Math.max(mx, ans);
            }
        }

        return mx * mx;
    }

    private int dfs(char[][] matrix, int[][] cache, int row, int col){
        if(row >= matrix.length || col >= matrix[0].length || matrix[row][col] == '0') return 0;
        if(cache[row][col] != -1) return cache[row][col];

        int right = dfs(matrix, cache, row, col+1);
        int down = dfs(matrix, cache, row+1, col);
        int diagonal = dfs(matrix, cache, row+1, col+1);

        return cache[row][col] = 1+Math.min(right, Math.min(down, diagonal));
    }
}
