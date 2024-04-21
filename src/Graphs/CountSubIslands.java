package Graphs;

public class CountSubIslands {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int res = 0;

        for(int row = 0; row < grid1.length; row++){
            for(int col = 0; col < grid1[0].length; col++){
                if(grid2[row][col] == 1){
                    if(dfs(grid1, grid2, row, col)) res++;
                }
            }
        }

        return res;
    }

    private boolean dfs(int[][] grid1, int[][] grid2, int row, int col){
        if(row < 0 || row >= grid1.length || col < 0 || col >= grid1[0].length || grid2[row][col] != 1) return true;
        if(grid1[row][col] != 1) return false;

        grid2[row][col] = -1;

        boolean a1 = dfs(grid1, grid2, row+1, col);
        boolean a2 = dfs(grid1, grid2, row-1, col);
        boolean a3 = dfs(grid1, grid2, row, col+1);
        boolean a4 = dfs(grid1, grid2, row, col-1);

        return a1 && a2 && a3 && a4;
    }
}
