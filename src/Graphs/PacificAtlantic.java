package Graphs;

import java.util.ArrayList;
import java.util.List;

public class PacificAtlantic {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();

        for(int row = 0; row < heights.length; row++){
            for(int col = 0; col < heights[0].length; col++){
                int[] canFlow = new int[2];
                dfs(heights, row, col, canFlow, heights[row][col]);
                if(canFlow[0] == 1 && canFlow[1] == 1){
                    List<Integer> cords = new ArrayList<>();
                    cords.add(row);
                    cords.add(col);
                    res.add(cords);
                }
            }
        }

        return res;
    }

    private void dfs(int[][] heights, int row, int col, int[] canFlow, int prev){
        if((canFlow[0] == 1 && canFlow[1] == 1) || row < 0 || row >= heights.length || col < 0 || col >= heights[0].length || heights[row][col] > prev || heights[row][col] == -1) return;

        if(row == 0 || col == 0) canFlow[0] = 1;

        if(row == heights.length-1 || col == heights[0].length-1) canFlow[1] = 1;

        int temp = heights[row][col];
        heights[row][col] = -1;

        dfs(heights, row+1, col, canFlow, temp);
        dfs(heights, row-1, col, canFlow, temp);
        dfs(heights, row, col+1, canFlow, temp);
        dfs(heights, row, col-1, canFlow, temp);

        heights[row][col] = temp;
    }
}
