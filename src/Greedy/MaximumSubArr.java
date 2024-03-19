package Greedy;

public class MaximumSubArr {
    public int maxSubArray(int[] nums) {
        int mxSoFar = Integer.MIN_VALUE, sum = 0;

        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            mxSoFar = Math.max(mxSoFar, sum);
            if(sum < 0) sum = 0;
        }

        return mxSoFar;
    }
}
