package Graphs;

import java.awt.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInBinaryMatrix {
//    public int shortestPathBinaryMatrix(int[][] grid) {
//        Queue<int[]> q = new LinkedList<>(); // [row, col, move]
//        q.add(new int[]{0,0,0});
//        HashSet<Point> visited = new HashSet<>();
//        visited.add(new Point(0,0));
//
//        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {-1, -1}, {1, -1}, {-1, 1}};
//
//        while(!q.isEmpty()){
//            int[] top = q.poll();
//            int row = top[0], col = top[1], move = top[2];
//
//            if(row < 0 || row >= grid.length || col < 0 || col >= grid.length || grid[row][col] == 1) continue;
//
//            if(row == grid.length-1 && col == grid.length-1) return move+1;
//
//            for(int[] d : dirs){
//                int r = row + d[0];
//                int c = col + d[1];
//
//                if(!visited.contains(new Point(r, c))){
//                    visited.add(new Point(r, c));
//                    q.add(new int[]{r, c, move+1});
//                }
//            }
//        }
//
//        return -1;
//    }

    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0] == 1) return -1;

        Queue<int[]> q = new LinkedList<>(); // [row, col, move]
        q.add(new int[]{0,0,1});
        HashSet<Point> visited = new HashSet<>();
        visited.add(new Point(0,0));

        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {-1, -1}, {1, -1}, {-1, 1}};

        while(!q.isEmpty()){
            int[] top = q.poll();
            int row = top[0], col = top[1], move = top[2];

            if(row == grid.length-1 && col == grid.length-1) return move;

            for(int[] d : dirs){
                int r = row + d[0];
                int c = col + d[1];

                if(r >= 0 && r < grid.length && c >= 0 && c < grid.length && grid[r][c] != 1 && !visited.contains(new Point(r, c))){
                    visited.add(new Point(r, c));
                    q.add(new int[]{r, c, move+1});
                }
            }
        }

        return -1;
    }
}
