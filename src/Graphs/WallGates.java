package Graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class WallGates {
    public static void wallsAndGates(int[][] rooms) {
        Queue<Integer[]> q = new LinkedList<>();

        for(int row = 0; row < rooms.length; row++){
            for(int col = 0; col < rooms[0].length; col++){
                if(rooms[row][col] == 0){
                    q.add(new Integer[]{row, col});
                }
            }
        }

        int[][] dirs = new int[][]{ {1, 0}, {-1, 0}, {0, 1}, {0, -1} };

        while(!q.isEmpty()){
            int qLen = q.size();
            for(int i = 0; i < qLen; i++){
                Integer[] cords = q.poll();
                for(int[] d : dirs){
                    int r = cords[0] + d[0];
                    int c = cords[1] + d[1];

                    if(r >= 0 && r < rooms.length && c >= 0 && c < rooms[0].length && rooms[r][c] == Integer.MAX_VALUE){
                        q.add(new Integer[]{r, c});
                        rooms[r][c] = rooms[cords[0]][cords[1]]+1;
                    }
                }
            }
        }
    }



    public static void main(String[] args) {
        int[][] grid = new int[][]{{2147483647,-1,0,2147483647},{2147483647,2147483647,2147483647,-1},{2147483647,-1,2147483647,-1},{0,-1,2147483647,2147483647}};
        wallsAndGates(grid);
        System.out.println(Arrays.deepToString(grid));
    }
}
