package BinarySearch;

public class Src2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int ol = 0;
        int or = matrix.length - 1;
        while (ol <= or){
            int om = (ol + or)/2;
            if(matrix[om][0] < target){
                ol = om + 1;
            }else if (matrix[om][0] > target){
                or = om - 1;
                continue;
            }else return true;

            int il = 0;
            int ir = matrix[om].length - 1;
            while(il <= ir){
                int im = (il + ir)/2;
                if(matrix[om][im] < target){
                    il = im + 1;
                } else if (matrix[om][im] > target) {
                    ir = im - 1;
                }else return true;
            }
        }

        return false;
    }
}
