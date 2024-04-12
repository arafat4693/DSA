package TwoPointers;

public class RmDupliFromSortedArr {
    public int removeDuplicates(int[] nums) {
        int idx = 1, curr = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(nums[i] != curr) nums[idx++] = curr = nums[i];
        }
        return idx;
    }
}
