package ArrayAndHashing;

import java.util.Arrays;

public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        for(int i = 0; i < nums.length; i++) if(nums[i] < 0) nums[i] = 0;

        for(int i = 0; i < nums.length; i++){
            int idx = Math.abs(nums[i]) - 1;
            if(idx >= 0 && idx < nums.length){
                if(nums[idx] > 0) nums[idx] *= -1;
                else if(nums[idx] == 0) nums[idx] = -1 * (nums.length+1);
            }
        }

        for(int i = 1; i <= nums.length; i++){
            if(nums[i-1] >= 0) return i;
        }

        return nums.length+1;
    }
}
