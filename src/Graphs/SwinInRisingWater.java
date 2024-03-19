package Graphs;

import java.util.*;

public class SwinInRisingWater {
    public int swimInWater(int[][] grid) {
        HashMap<Integer, List<Integer>> adj = new HashMap<>();
        int n = grid.length;
        for(int row = 0; row < n; row++){
            for(int col = 0; col < n; col++) adj.put(grid[row][col], new ArrayList<>());
        }

        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        for(int row = 0; row < n; row++){
            for(int col = 0; col < n; col++){

                for(int[] d : dirs){
                    int r = row + d[0];
                    int c = col + d[1];

                    if(r >= 0 && r < n && c >= 0 && c < n) adj.get(grid[row][col]).add(grid[r][c]);
                }

            }
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> a - b);
        minHeap.add(grid[0][0]);
        HashSet<Integer> visited = new HashSet<>();
        HashSet<Integer> visiting = new HashSet<>();
        visiting.add(grid[0][0]);
        int t = 0;

        while(!visiting.contains(grid[n-1][n-1])){
            int top = minHeap.poll();
            visiting.remove(top);
            visited.add(top);
            t = Math.max(t, top);
            for(Integer nei : adj.get(top)){
                if(!visited.contains(nei)){
                    minHeap.add(nei);
                    visiting.add(nei);
                }
            }
        }

        return Math.max(t, grid[n-1][n-1]);
    }
}
