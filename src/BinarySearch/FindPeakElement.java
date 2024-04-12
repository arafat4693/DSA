package BinarySearch;

import java.util.Arrays;

public class FindPeakElement {
//    public int findPeakElement(int[] nums) {
//        long[] num = new long[nums.length+2];
//        num[0] = num[num.length-1] = Long.MIN_VALUE;
//
//        for(int i = 0; i < nums.length; i++) num[i+1] = nums[i];
//        System.out.println(Arrays.toString(num));
//        int l = 0, res = 0;
//
//        for(int i = 1; i < num.length-1; i++){
//            if(num[i] > num[l] && num[i] > num[i+1]) {
//                res = i-1;
//                break;
//            }
//            l++;
//        }
//
//        return res;
//    }

    public int findPeakElement(int[] nums){
        int l = 0, r = nums.length-1;

        while(l <= r){
            int m = (l+r)/2;
            if(m < nums.length-1 && nums[m] < nums[m+1]) l = m+1;
            else if(m > 0 && nums[m] < nums[m-1]) r = m-1;
            else return m;
        }

        return -1;
    }
}
