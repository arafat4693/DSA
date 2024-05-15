package DP;

import java.util.Arrays;

public class NonDecreasingArray {
    public boolean checkPossibility(int[] nums) {
        int[] cache = new int[nums.length];
        Arrays.fill(cache, 1);

        int mx = 0;

        for(int i = nums.length-2; i >= 0; i--){
            for(int j = i+1; j < nums.length; j++){
                if(nums[i] <= nums[j]) cache[i] = Math.max(cache[i], cache[j]+1);
            }
            mx = Math.max(mx, cache[i]);
        }

        return nums.length - mx <= 1;
    }
}
