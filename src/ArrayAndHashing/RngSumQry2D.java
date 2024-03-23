package ArrayAndHashing;

public class RngSumQry2D {
    int[][] sumMat;
    public RngSumQry2D(int[][] matrix) {
        sumMat = new int[matrix.length+1][matrix[0].length+1];

        for(int i = 0; i < matrix.length; i++) {
            int prefix = 0;
            for (int j = 0; j < matrix[0].length; j++) {
                prefix += matrix[i][j];
                int above = sumMat[i][j+1];
                sumMat[i+1][j+1] = prefix + above;
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int r1 = row1+1, c1 = col1+1, r2 = row2+1, c2 = col2+1;

        int bottomLeft = sumMat[r2][c1-1];
        int topRight = sumMat[r1-1][c2];
        int topLeft = sumMat[r1-1][c1-1];

        return sumMat[r2][c2]-bottomLeft-topRight+topLeft;
    }

}
