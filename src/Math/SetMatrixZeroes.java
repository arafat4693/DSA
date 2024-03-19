package Math;

public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        int column = matrix[0][0];

        for(int row = 0; row < matrix.length; row++){
            for(int col = 0; col < matrix[0].length; col++){
                if(matrix[row][col] == 0){
                    matrix[row][0] = 0;
                    if(col != 0) matrix[0][col] = 0;
                    else column = 0;
                }
            }
        }

        for(int row = 1; row < matrix.length; row++){
            for(int col = 1; col < matrix[0].length; col++){
                if(matrix[row][col] != 0 && (matrix[row][0] == 0 || matrix[0][col] == 0)) matrix[row][col] = 0;
            }
        }

        if(matrix[0][0] == 0) for(int i = 1; i < matrix[0].length; i++) matrix[0][i] = 0;

        if(column == 0 ) for(int i = 0; i < matrix.length; i++) matrix[i][0] = 0;

    }
}
