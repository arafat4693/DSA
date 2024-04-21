package ArrayAndHashing;

import java.util.Arrays;

public class GridGame {
    public long gridGame(int[][] grid) {
        int col = grid[0].length;

        long[] pSum = new long[col];
        pSum[col-1] = grid[0][col-1];

        for(int i = col-2; i >= 0; i--){
            pSum[i] = grid[0][i] + pSum[i+1];
        }

        long[] sSum = new long[col];
        sSum[0] = grid[1][0];

        for(int i = 1; i < col; i++){
            sSum[i] = sSum[i-1] + grid[1][i];
        }

        long res = Long.MAX_VALUE;

        for(int i = 0; i < col; i++){
            long localSum = 0;
            if(i-1 >= 0) localSum += sSum[i-1];
            if(i+1 < col) localSum = Math.max(pSum[i+1], localSum);

            res = Math.min(res, localSum);
        }

        return res;
    }
}
