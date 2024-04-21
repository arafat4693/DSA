package ArrayAndHashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Shift2DGrid {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int R = grid.length, C = grid[0].length;

        int[][] newRes = new int[R][C];

        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                int arrIdx = ((i*C+j) + k) % (R*C); // after shift
                int r = arrIdx/C, c = arrIdx%C;
                newRes[r][c] = grid[i][j];
            }
        }

        return convertArrayToList(newRes);
    }

    public List<List<Integer>> convertArrayToList(int[][] array) {
        List<List<Integer>> list = new ArrayList<>();
        for (int[] row : array) {
            List<Integer> tempList = new ArrayList<>();
            for (int value : row) {
                tempList.add(value);
            }
            list.add(tempList);
        }
        return list;
    }
}
