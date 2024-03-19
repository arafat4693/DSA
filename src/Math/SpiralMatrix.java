package Math;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>(matrix.length * matrix[0].length);

        int top = 0, left = 0, right = matrix[0].length - 1, bottom = matrix.length-1;

        while(top <= bottom && left <= right){
            for(int i = left; i <= right; i++){
                ans.add(matrix[top][i]);
            }
            top++;

            for(int i = top; i <= bottom; i++){
                ans.add(matrix[i][right]);
            }
            right--;

            if(top <= bottom){
                for(int i = right; i >= left; i--){
                    ans.add(matrix[bottom][i]);
                }
                bottom--;
            }

            if(right >= left){
                for(int i = bottom; i >= top; i--){
                    ans.add(matrix[i][left]);
                }
                left++;
            }
        }

        return ans;
    }
}
