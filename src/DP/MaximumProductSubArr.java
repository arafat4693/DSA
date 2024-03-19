package DP;

import java.util.Arrays;

public class MaximumProductSubArr {
    public int maxProduct(int[] nums) {
        int res = Integer.MIN_VALUE;
        int curMax = 1, curMin = 1;

        for(int n : nums){
            if(n == 0){
                curMin = curMax = 1;
                res = Math.max(res, 0);
                continue;
            }
            int tmp = n * curMax;
            curMax = Math.max(Math.max(tmp, n * curMin), n);
            curMin = Math.min(Math.min(tmp, n * curMin), n);
            res = Math.max(curMax, res);
        }

        return res;
    }
}
