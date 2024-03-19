package BinarySearch;

import java.util.Arrays;

public class Median2Sorted {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums2.length < nums1.length){
            int[] temp = nums2;
            nums2 = nums1;
            nums1 = temp;
        }

        System.out.println("nums1: " + Arrays.toString(nums1));
        System.out.println("nums2: " + Arrays.toString(nums2));

        int total = nums1.length + nums2.length;
        int l = 0, r = nums1.length - 1, half = total/2;

        while(true){
            int i = (l + r) < 0 ? -1 : (l + r)/2;
            int j = half - i - 2;

            int n1Left = i >= 0 ? nums1[i] : Integer.MIN_VALUE;
            int n1Right = (i+1) >= nums1.length ? Integer.MAX_VALUE : nums1[i +1];
            int n2Left = j >= 0 ? nums2[j] : Integer.MIN_VALUE;
            int n2Right = (j+1) >= nums2.length ? Integer.MAX_VALUE : nums2[j +1];

            if(n1Left <= n2Right && n2Left <= n1Right) {
                if(total % 2 == 1) return Math.min(n1Right, n2Right);
                else return (double) (Math.max(n1Left, n2Left) + Math.min(n1Right, n2Right)) / 2;
            }else if(n1Left > n2Right) r = i - 1;
            else l = i + 1;
        }
    }

    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{1,3}, new int[]{2}));
    }
}
