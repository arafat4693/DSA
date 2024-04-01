package Graphs;

import java.awt.*;
import java.util.*;

public class PathWithMinimumEffort {
    static class State{
        int row;
        int col;
        int diff;
        State(int r, int c, int d){
            row = r;
            col = c;
            diff = d;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof State state)) return false;
            return row == state.row && col == state.col;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, col);
        }
    }

    public int minimumEffortPath(int[][] heights) {
        int[][] dirs = new int[][]{ {1, 0}, {-1, 0}, {0, 1}, {0, -1} };

        PriorityQueue<State> q = new PriorityQueue<>((a, b) -> a.diff - b.diff);
        HashSet<State> visited = new HashSet<>();

        q.add(new State(0,0,0)); // 0: row <-> 1: col <-> 2: diff

        while(true){
            State top = q.poll();
            if(top.row == heights.length-1 && top.col == heights[0].length-1){
                return top.diff;
            }
            if(visited.contains(new State(top.row, top.col, top.diff))) continue;
            visited.add(new State(top.row, top.col, top.diff));

            for(int[] dir : dirs){
                int r = top.row + dir[0];
                int c = top.col + dir[1];

                if(r >= 0 && r < heights.length && c >= 0 && c < heights[0].length){
                    int newDiff = Math.max(Math.abs(heights[r][c] - heights[top.row][top.col]), top.diff);
                    if(!visited.contains(new State(r, c, newDiff))){
//                        System.out.println("row" + r + " -> " + "col" + c);
                        q.add(new State(r, c, newDiff));
                    }
                }
            }
        }
    }
}
