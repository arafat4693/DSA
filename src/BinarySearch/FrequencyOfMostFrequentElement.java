package BinarySearch;

import java.util.Arrays;

public class FrequencyOfMostFrequentElement {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);

        int[] pSum = new int[nums.length];
        pSum[0] = nums[0];
        for(int i = 1; i < nums.length; i++) pSum[i] = nums[i] + pSum[i-1];

        int res = 1;

        for(int i = 1; i < nums.length; i++){
            int l = 0, r = i;
            while(l <= r){
                int m = (l+r)/2;
                int cs = (i-m+1)*nums[i];
                int as = pSum[i] - (m-1 < 0 ? 0 : pSum[m-1]);
                if((cs - as) > k) l = m+1;
                else {
                    res = Math.max(res, i-m+1);
                    r = m-1;
                }
            }
        }

        return res;
    }
}
