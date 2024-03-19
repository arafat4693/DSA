package Math;

import java.util.Arrays;

public class RotateImage {
    public void rotate(int[][] matrix) {
        for(int i = 0; i < matrix.length-1; i++){
            for(int j = i+1; j < matrix.length; j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }

        for(int[] row : matrix){
            for(int i = 0; i < row.length / 2; i++) {
                int temp = row[i];
                row[i] = row[row.length - i - 1];
                row[row.length - i - 1] = temp;
            }
        }
    }
}
