package SlidingWindow;

public class MinSizeSubArrSum {
    public int minSubArrayLen(int target, int[] nums) {
        int res = Integer.MAX_VALUE, l = 0, sum = 0;

        for(int r = 0; r < nums.length; r++){
            sum += nums[r];
            while(sum >= target && l <= r){
                sum -= nums[l];
                res = Math.min(r-l+1, res);
                l++;
            }
        }

        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
