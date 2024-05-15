package ArrayAndHashing;

import java.util.Arrays;

public class SortAnArray {
    public int[] sortArray(int[] nums) {
        if(nums.length == 1) return nums;

        int[] a = new int[nums.length/2];
        int[] b = new int[nums.length - (nums.length/2)];

        System.arraycopy(nums, 0, a, 0, nums.length / 2);
        for(int i = nums.length/2; i < nums.length; i++) b[i-nums.length/2] = nums[i];

        a = sortArray(a);
        b = sortArray(b);
        merge(a, b, nums);
        return nums;
    }

    private void merge(int[] a, int[] b, int[] c){
        int ai = 0, bi = 0, ci = 0;

        while(ai < a.length && bi < b.length){
            if(a[ai] <= b[bi]) c[ci++] = a[ai++];
            else c[ci++] = b[bi++];
        }

        while(ai < a.length) c[ci++] = a[ai++];
        while(bi < b.length) c[ci++] = b[bi++];
    }
}
