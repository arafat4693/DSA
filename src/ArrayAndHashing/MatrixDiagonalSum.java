package ArrayAndHashing;

public class MatrixDiagonalSum {
    public int diagonalSum(int[][] mat) {
        int sum = 0;

        for(int i = 0; i < mat.length; i++){
            sum += mat[i][i];
            mat[i][i] = -1;
            if(mat[i][mat.length-1-i] != -1) sum += mat[i][mat.length-1-i];
        }

        return sum;
    }
}
