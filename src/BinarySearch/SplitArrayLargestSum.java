package BinarySearch;

public class SplitArrayLargestSum {
    public int splitArray(int[] nums, int k) {
        int l = 0, r = 0;
        for(int n : nums){
            l = Math.max(l, n);
            r += n;
        }

        int res = Integer.MAX_VALUE;
        while(l <= r){
            int m = (l+r)/2;
            if(solve(nums, m, k)){
                res = m;
                r = m-1;
            }else l = m+1;
        }

        return res;
    }

    private boolean solve(int[] nums, int target, int k){
        int count = 1, sum = 0;
        for(int n : nums){
            sum += n;
            if(sum > target){
                count++;
                sum = n;
            }
        }
        return count <= k;
    }
}
