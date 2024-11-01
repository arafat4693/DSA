package ArrayAndHashing;

import java.util.HashMap;

public class NrOfSubMatricesThatSumToTarget {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int rows = matrix.length, cols = matrix[0].length;

        int[][] prefix = new int[rows][cols];
        for(int i = 0; i < rows; i++){
            int total = 0;
            for(int j = 0; j < cols; j++){
                total += matrix[i][j];
                prefix[i][j] = total;
            }
        }

        int res = 0;

        for(int sc = 0; sc < cols; sc++){

            for(int c = sc; c < cols; c++){
                HashMap<Integer, Integer> map = new HashMap<>();
                map.put(0, 1);
                int total = 0;

                for(int r = 0; r < rows; r++){
                    total += (prefix[r][c] - (sc - 1 < 0 ? 0 : prefix[r][sc-1]));
                    if(map.containsKey(total - target)) res += map.get(total - target);
                    map.put(total, map.getOrDefault(total, 0) + 1);
                }
            }

        }

        return res;
    }
}
