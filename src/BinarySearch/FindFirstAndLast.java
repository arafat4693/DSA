package BinarySearch;

import java.util.Arrays;

public class FindFirstAndLast {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        Arrays.fill(res, -1);

        int l = 0, r = nums.length-1;
        while(l <= r){
            int m = (l+r)/2;
            if(nums[m] == target){
                res[0] = m;
                r = m-1;
            }else if(nums[m] < target) l = m+1;
            else r = m-1;
        }

        if(res[0] == -1) return res;

        l = res[0];
        r = nums.length-1;

        while(l <= r){
            int m = (l+r)/2;
            if(nums[m] == target){
                res[1] = m;
                l = m+1;
            }else if(nums[m] < target) l = m+1;
            else r = m-1;
        }

        return res;
    }
}
