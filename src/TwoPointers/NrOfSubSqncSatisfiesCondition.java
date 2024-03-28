package TwoPointers;

import java.util.Arrays;

public class NrOfSubSqncSatisfiesCondition {
    public int numSubseq(int[] nums, int target) {
        int ans = 0;
        int mod = (int) Math.pow(10, 9) + 7;

        Arrays.sort(nums);

        int[] exp = new int[nums.length];
        exp[0] = 1;

        for (int i=1; i<nums.length; i++)
            exp[i] = (exp[i-1] * 2) % mod;

        int r = nums.length-1;

        for(int i = 0; i < nums.length; i++){
            while(i <= r && (nums[i]+nums[r] > target)) r--;
            if(i <= r) {
                ans += exp[r-i];
                ans %= mod;
            }
        }

        return ans;
    }
}
