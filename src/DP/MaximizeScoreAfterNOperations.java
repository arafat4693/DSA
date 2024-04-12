package DP;

import java.util.Arrays;
import java.util.HashMap;

public class MaximizeScoreAfterNOperations {
    static class Arr{
        int[] arr;
        Arr(int[] arr){
            this.arr = arr;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Arr arr1)) return false;
            return Arrays.equals(arr, arr1.arr);
        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(arr);
        }
    }

//    public int maxScore(int[] nums) {
//        HashMap<Arr, Integer> cache = new HashMap<>();
//        return backtrack(nums, 1, cache);
//    }
//
//    private int backtrack(int[] nums, int ops, HashMap<Arr, Integer> cache){
//        if(cache.get(new Arr(nums)) != null) return cache.get(new Arr(nums));
//
//        int ans = 0;
//
//        for(int i = 0; i < nums.length-1; i++){
//            if(nums[i] == -1) continue;
//
//            int n1 = nums[i];
//            nums[i] = -1;
//            for(int j = i+1; j < nums.length; j++){
//                if(nums[j] == -1) continue;
//
//                int n2 = nums[j];
//                nums[j] = -1;
//
//                ans = Math.max(ans, (ops * gcd(n1, n2) + backtrack(nums, ops+1, cache)));
//
//                nums[j] = n2;
//            }
//
//            nums[i] = n1;
//        }
//
//        cache.put(new Arr(nums), ans);
//        return ans;
//    }

    public static int maxScore(int[] nums) {
        int[] cache = new int[(int)Math.pow(2, nums.length)];
        return dfs(nums, 1, cache, 0);
    }

    private static int dfs(int[] nums, int ops, int[] cache, int mask){
        if(cache[mask] != 0) return cache[mask];

        for(int i = 0; i < nums.length-1; i++){
            for(int j = i+1; j < nums.length; j++){
                if(((1 << i) & mask) != 0 || ((1 << j) & mask) != 0) continue;

                int newMask = mask | (1 << i) | (1 << j);
                cache[mask] = Math.max(cache[mask], ops * gcd(nums[i], nums[j]) + dfs(nums, ops+1, cache, newMask));
            }
        }

        return cache[mask];
    }

    private static int gcd(int a, int b){
        if (b == 0)
            return a;
        else
            return gcd(b, a % b);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 4, 6, 8};
        System.out.println(maxScore(nums));
    }
}
