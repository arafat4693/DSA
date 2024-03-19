package Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class rottingOranges {
    public int orangesRotting(int[][] grid) {
        Queue<Integer[]> q = new LinkedList<>();

        for(int row = 0; row < grid.length; row++){
            for(int col = 0; col < grid[0].length; col++){
                if (grid[row][col] == 2) q.add(new Integer[]{row, col});
            }
        }

        int[][] dirs = new int[][]{ {1, 0}, {-1, 0}, {0, 1}, {0, -1} };
        int time = -1;

        while(!q.isEmpty()){
            int qLen = q.size();
            time++;
            for(int i = 0; i < qLen; i++){
                Integer[] cords = q.poll();
                for(int[] d : dirs){
                    int r = cords[0] + d[0];
                    int c = cords[1] + d[1];

                    if(r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && grid[r][c] == 1){
                        q.add(new Integer[]{r, c});
                        grid[r][c] = 2;
                    }
                }

            }
        }

        boolean isOnlyZero = true;
        for(int row = 0; row < grid.length; row++){
            for(int col = 0; col < grid[0].length; col++){
                if (grid[row][col] == 1) return -1;
                if(grid[row][col] == 2 && isOnlyZero) isOnlyZero = false;
            }
        }

        return isOnlyZero ? 0 : time;
    }
}
