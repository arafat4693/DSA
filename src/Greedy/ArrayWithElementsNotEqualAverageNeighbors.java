package Greedy;

import java.util.Arrays;

public class ArrayWithElementsNotEqualAverageNeighbors {
    public int[] rearrangeArray(int[] nums) {
        Arrays.sort(nums);

        int[] res = new int[nums.length];
        int l = 0, r = nums.length-1, i = 0;

        while(i != nums.length){
            res[i++] = nums[l++];
            if(l <= r){
                res[i++] = nums[r--];
            }
        }

        return res;
    }
}
