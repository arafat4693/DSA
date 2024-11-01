package SlidingWindow;

import java.util.HashMap;

public class LongestSubArrWithKFreq {
    public int maxSubarrayLength(int[] nums, int k) {
        HashMap<Integer, Integer> freq = new HashMap<>();

        int l = 0, length = 0;
        for(int r = 0; r < nums.length; r++){
            freq.put(nums[r], freq.getOrDefault(nums[r], 0)+1);
            int f = freq.get(nums[r]);
            if(f > k) {
                length = Math.max(length, r-l);
                while(l <= r && freq.get(nums[r]) > k){
                    freq.put(nums[l], freq.get(nums[l])-1);
                    l++;
                }
            }
        }

        if(freq.get(nums[nums.length-1]) <= k) length = Math.max(length, nums.length-l);

        return length;
    }
}
