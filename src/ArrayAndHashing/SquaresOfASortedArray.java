package ArrayAndHashing;

import java.util.ArrayList;
import java.util.List;

public class SquaresOfASortedArray {
    public int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];

        int l = 0, r = nums.length-1, idx = nums.length-1;

        while(l <= r){
            if(Math.abs(nums[l]) >= Math.abs(nums[r])){
                res[idx--] = nums[l]*nums[l];
                l++;
            }else{
                res[idx--] = nums[r]*nums[r];
                r--;
            }
        }

        return res;
    }
}
