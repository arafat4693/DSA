package DP;

import java.util.Arrays;
import java.util.HashMap;

public class NrOfLongestIncreasingSubSeq {
    public int findNumberOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int[] count = new int[nums.length];
        count[nums.length-1] = 1;
        Arrays.fill(dp, 1);

        for(int i = nums.length-2; i >= 0; i--){
            for(int j = i+1; j < nums.length; j++){
                if(nums[i] < nums[j]) dp[i] = Math.max(dp[i], dp[j]+1);
            }

            int lis = dp[i];

            for(int j = i+1; j < nums.length; j++){
                if(dp[j] == lis) count[i] += count[j];
                if(nums[i] < nums[j] && dp[j]+1 == lis) count[i] += count[j];
            }
        }

        System.out.println(Arrays.toString(dp));
        System.out.println(Arrays.toString(count));

        int ans = 0;
        for(int n : count) ans = Math.max(ans, n);
        return ans;
    }
}
