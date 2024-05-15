package Stacks;

import java.util.Arrays;
import java.util.Stack;

public class MaximumSubArrMinProduct {
    public int maxSumMinProduct(int[] nums) {
        int mod = 1000000007;

        Stack<long[]> mono = new Stack<>(); // [value, sum]

        long[] allSums = new long[nums.length];

        for(int i = nums.length-1; i >= 0; i--){
            long sum = nums[i];

            while(!mono.isEmpty() && mono.peek()[0] >= nums[i]){
                sum += mono.pop()[1];
            }

            mono.push(new long[]{nums[i], sum});
            allSums[i] = sum;
        }

        mono.clear();

        for(int i = 0; i < nums.length; i++){
            long sum = 0;

            while(!mono.isEmpty() && mono.peek()[0] >= nums[i]){
                sum += mono.pop()[1];
            }

            mono.push(new long[]{nums[i], sum+nums[i]});
            allSums[i] += sum;
        }

        long res = 0;

        for(int i = 0; i < nums.length; i++){
            res = Math.max(res, (long) nums[i]*allSums[i]);
        }

        return (int) (res%mod);
    }
}
