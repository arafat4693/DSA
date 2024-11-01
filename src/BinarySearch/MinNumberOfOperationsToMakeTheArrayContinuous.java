package BinarySearch;

import java.util.Arrays;
import java.util.HashSet;

public class MinNumberOfOperationsToMakeTheArrayContinuous {
    public int minOperations(int[] nums) {
        HashSet<Integer> unique = new HashSet<>();
        for(int n : nums) unique.add(n);

        int[] uArr = new int[unique.size()];
        int j = 0;
        for(int u : unique) uArr[j++] = u;
        Arrays.sort(uArr);

        int ops = Integer.MAX_VALUE;

        for(int i = 0; i < uArr.length; i++){
            int need = (nums.length-1) + uArr[i];
            int idx = lowerBound(uArr, need);

            int cnt = (uArr.length-idx-1) + i;
            cnt += (nums.length - uArr.length);
            ops = Math.min(ops, cnt);
        }

        return ops;
    }

    private int lowerBound(int[] arr, int target){
        int l = 0, r = arr.length-1, idx = 0;
        while(l <= r){
            int m = (l+r)/2;
            if(arr[m] <= target){
                idx = m;
                l = m+1;
            }else r = m-1;
        }
        return idx;
    }
}
