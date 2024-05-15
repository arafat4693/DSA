package Graphs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestBridge {

    Queue<int[]> q = new LinkedList<>(); //[row, col, count];

    public int shortestBridge(int[][] grid) {

        for(int row = 0; row < grid.length; row++){
            boolean flag = false;
            for(int col = 0; col < grid[0].length; col++){
                if(grid[row][col] == 1){
                    flag = true;
                    dfs1(grid, row, col);
                    break;
                }
            }
            if(flag) break;
        }

        int[][] dirs = new int[][]{ {1, 0}, {-1, 0}, {0, 1}, {0, -1} };

        while(!q.isEmpty()){
            int[] p = q.poll();
            int row = p[0], col = p[1], count = p[2];

            for(int[] d : dirs){
                int r = row + d[0];
                int c = col + d[1];

                if(r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == 2) continue;

                if(grid[r][c] == 1) return count;

                q.add(new int[]{r,c,count+1});
                grid[r][c] = 2;
            }
        }

        return 0;
    }

    private void dfs1(int[][] grid, int row, int col){
        if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] != 1) return;

        grid[row][col] = 2;
        q.add(new int[]{row, col, 0});

        dfs1(grid, row, col-1);
        dfs1(grid, row, col+1);
        dfs1(grid, row-1, col);
        dfs1(grid, row+1, col);
    }
}
