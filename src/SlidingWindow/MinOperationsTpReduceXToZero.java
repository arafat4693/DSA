package SlidingWindow;

import java.util.Arrays;

public class MinOperationsTpReduceXToZero {
    public int minOperations(int[] nums, int x) {
        int sum = Arrays.stream(nums).sum();
        int target = sum - x;

        if(target < 0) return -1;

        int total = 0, l = 0, len = -1;

        for(int r = 0; r < nums.length; r++){
            total += nums[r];
            while(total > target) total -= nums[l++];
            if(total == target){
                len = Math.max(len, r-l+1);
            }
        }

        if(len == -1) return -1;

        return nums.length - len;
    }
}
