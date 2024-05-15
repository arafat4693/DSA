package ArrayAndHashing;

import java.util.Arrays;

public class MaximumSumCircularSubArr {
    public int maxSubarraySumCircular(int[] nums) {
        int mx = Integer.MIN_VALUE, mn = Integer.MAX_VALUE, total = 0;
        int sumMx = 0, sumMn = 0;

        for(int i = 0; i < nums.length; i++){
            total += nums[i];
            sumMx += nums[i];
            sumMn += nums[i];

            mx = Math.max(sumMx, mx);
            mn = Math.min(sumMn, mn);

            if(sumMx < 0) sumMx = 0;
            if(sumMn > 0) sumMn = 0;
        }

        return Math.max(mx, total-mn == 0 ? mn : total-mn);
    }

//    public int maxSubarraySumCircular(int[] nums) {
//        int mxSum = Integer.MIN_VALUE;
//
//        for(int i = 0; i < nums.length; i++){
//            int idx = i;
//            int sum = 0;
//
//            while(idx < i+nums.length){
//                int j = idx%nums.length;
//                sum += nums[j];
//                mxSum = Math.max(mxSum, sum);
//                if(sum < 0) sum = 0;
//                idx++;
//            }
//        }
//
//        return mxSum;
//    }
}
