package Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class NrOfIslands {
    int count = 0;
    public int numIslands(char[][] grid) {
        for(int row = 0; row < grid.length; row++){
            for(int col = 0; col < grid[0].length; col++){
                if(grid[row][col] == '1'){
                    dfs(grid, row, col);
                    count++;
                }
            }
        }

        return count;
    }

    private void dfs(char[][] grid, int row, int col){
        if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] != '1') return;

        grid[row][col] = '#';

        dfs(grid, row+1, col);
        dfs(grid, row-1, col);
        dfs(grid, row, col+1);
        dfs(grid, row, col-1);
    }

    private void bfs(char[][] grid, int row, int col){
        Queue<Integer[]> q = new LinkedList<>();
        q.add(new Integer[]{row, col});
        grid[row][col] = '#';

        int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while (!q.isEmpty()){
            Integer[] cord = q.poll();
            for(int[] d : directions){
                if(
                        (cord[0] + d[0] >= 0) && (cord[0] + d[0] < grid.length) && (cord[1] + d[1] >= 0) && (cord[1] + d[1] < grid[0].length) && (grid[cord[0] + d[0]][cord[1] + d[1]] == '1')
                ){
                    q.add(new Integer[]{cord[0] + d[0], cord[1] + d[1]});
                    grid[cord[0] + d[0]][cord[1] + d[1]] = '#';
                }
            }
        }
    }
}
