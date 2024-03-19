package Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class MaxAreaOfIslands {
    public int maxAreaOfIsland(int[][] grid) {
        int count = 0;

        for(int row = 0; row < grid.length; row++){
            for(int col = 0; col < grid[0].length; col++){
                if(grid[row][col] == 1){
                    int[] islands = new int[1];
                    dfs(grid, islands, row, col);
                    count = Math.max(count, islands[0]);
                }
            }
        }

        return count;
    }

    private void dfs(int[][] grid, int[] islands, int row, int col){
        if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] != 1) return;

        islands[0]++;
        grid[row][col] = -1;

        dfs(grid, islands, row+1, col);
        dfs(grid, islands, row-1, col);
        dfs(grid, islands, row, col+1);
        dfs(grid, islands, row, col-1);
    }

    private void bfs(int[][] grid, int[] islands, int row, int col){
        Queue<Integer[]> q = new LinkedList<>();
        q.add(new Integer[]{row, col});
        grid[row][col] = -1;
        islands[0]++;

        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while(!q.isEmpty()){
            Integer[] cords = q.poll();

            for(int[] d : dirs){
                int r = cords[0] + d[0];
                int c = cords[1] + d[1];

                if(r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && grid[r][c] == 1){
                    islands[0]++;
                    q.add(new Integer[]{r, c});
                    grid[r][c] = -1;
                }
            }
        }
    }
}
