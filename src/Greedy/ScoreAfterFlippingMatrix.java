package Greedy;

public class ScoreAfterFlippingMatrix {
    public int matrixScore(int[][] grid) {
        // return dfs(grid, 0, 0);
        int sum = 0;

        for(int row = 0; row < grid.length; row++){
            int oldVal = rowVal(grid, row);
            toggleRow(grid, row);
            int newVal = rowVal(grid, row);

            if(newVal < oldVal) toggleRow(grid, row);
        }

        for(int col = 0; col < grid[0].length; col++){
            int oldVal = colVal(grid, col);
            toggleCol(grid, col);
            int newVal = colVal(grid, col);

            if(newVal < oldVal) toggleCol(grid, col);
        }

        for(int row = 0; row < grid.length; row++){
            sum += rowVal(grid, row);
        }

        return sum;
    }

    private int rowVal(int[][] grid, int row){
        int num = 0;
        for(int j = 0; j < grid[0].length; j++) {
            num += (grid[row][j] << (grid[0].length - j - 1));
        }
        return num;
    }

    private int colVal(int[][] grid, int col){
        int num = 0;
        for(int j = 0; j < grid.length; j++) {
            num += (grid[j][col] << (grid[0].length - col - 1));
        }
        return num;
    }

    private void toggleRow(int[][] grid, int row){
        for(int i = 0; i < grid[0].length; i++) grid[row][i] = grid[row][i] == 1 ? 0 : 1;
    }

    private void toggleCol(int[][] grid, int col){
        for(int i = 0; i < grid.length; i++) grid[i][col] = grid[i][col] == 1 ? 0 : 1;
    }

    private int dfs(int[][] grid, int row, int col){
        if(row >= grid.length || col >= grid[0].length){
            int sum = 0;
            for(int i = 0; i < grid.length; i++){
                int num = 0;
                for(int j = 0; j < grid[0].length; j++) {
                    num += (grid[i][j] << (grid[0].length - j - 1));
                }
                sum += num;
            }
            return sum;
        };

        int ans = Math.max(dfs(grid, row+1, col), dfs(grid, row, col+1));

        for(int i = 0; i < grid[0].length; i++) grid[row][i] = grid[row][i] == 1 ? 0 : 1;
        ans = Math.max(ans, dfs(grid, row+1, col));
        for(int i = 0; i < grid[0].length; i++) grid[row][i] = grid[row][i] == 1 ? 0 : 1;

        for(int i = 0; i < grid.length; i++) grid[i][col] = grid[i][col] == 1 ? 0 : 1;
        ans = Math.max(ans, dfs(grid, row, col+1));
        for(int i = 0; i < grid.length; i++) grid[i][col] = grid[i][col] == 1 ? 0 : 1;

        return ans;
    }
}
