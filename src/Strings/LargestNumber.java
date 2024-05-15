package Strings;

import java.util.Arrays;

public class LargestNumber {
    public String largestNumber(int[] nums) {
        String[] arr = new String[nums.length];

        for(int i=0; i<nums.length; i++) {
            arr[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(arr, (s1, s2) -> {
            String n1 = s1 + s2, n2 = s2 + s1;
            return n2.compareTo(n1);
        });

        if(arr[0].equals("0")) return "0";

        StringBuilder res = new StringBuilder();
        for(String s : arr) res.append(s);

        return res.toString();
    }
}
