package BinarySearch;

public class SingleElementInSortedArr {
    public int singleNonDuplicate(int[] nums) {
        // int res = 0;
        // for(int n : nums) res ^= n;
        // return res;

        int l = 0, r = nums.length-1;

        while(l <= r){
            int m = (l+r)/2;

            if(m+1 < nums.length && nums[m+1] == nums[m]){
                if(((m+1)+1) % 2 == 0) l = m+1;
                else r = m-1;
            }else if(m-1 >= 0 && nums[m-1] == nums[m]){
                if((m+1) % 2 == 0) l = m+1;
                else r = m-1;
            }else return nums[m];
        }

        return 0;
    }
}
