package DP;

public class LongestIncreasingPathInMatrix {
    int mx;
    public int longestIncreasingPath(int[][] matrix) {
        int[][] dirs = new int[][]{ {1, 0}, {-1, 0}, {0, 1}, {0, -1} };
        int[][] cache = new int[matrix.length][matrix[0].length];

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++) cache[i][j] = -1;
        }

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                dfs(matrix, i, j, cache, -1, dirs);
            }
        }

        return mx;
    }

    private int dfs(int[][] matrix, int row, int col, int[][] cache, int prev, int[][] dirs){
        if(row >= matrix.length || row < 0 || col >= matrix[0].length || col < 0 || matrix[row][col] <= prev) return 0;
        if(cache[row][col] != -1) return cache[row][col];

        int ans = 0;

        for(int[] d : dirs){
            int r = row + d[0];
            int c = col + d[1];
            ans = Math.max(ans, 1+dfs(matrix, r, c, cache, matrix[row][col], dirs));
        }

        mx = Math.max(mx, ans);
        return cache[row][col] = ans;
    }
}
