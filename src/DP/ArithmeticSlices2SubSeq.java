package DP;

import java.util.Arrays;
import java.util.HashMap;

public class ArithmeticSlices2SubSeq {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length, res = 0;

        HashMap<Integer, Integer>[] dp = new HashMap[n];

        for(int i = n-1; i >= 0; i--){
            dp[i] = new HashMap<>();

            for(int j = i+1; j < n; j++){
                long d = (long) nums[i] - nums[j];
                if (d < Integer.MIN_VALUE || d > Integer.MAX_VALUE) continue;

                int diff = (int) d;
                int count = dp[j].getOrDefault(diff, 0);
                res += count;
                dp[i].put(diff, dp[i].getOrDefault(diff, 0)+count+1);
            }
        }

        // System.out.println(Arrays.toString(dp));

        return res;
    }
}
