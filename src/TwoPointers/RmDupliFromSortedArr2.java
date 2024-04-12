package TwoPointers;

public class RmDupliFromSortedArr2 {
    public int removeDuplicates(int[] nums) {
        int idx = 1, cnt = 1, curr = nums[0];

        for(int i = 1; i < nums.length; i++){
            if(nums[i] != curr){
                nums[idx++] = curr = nums[i];
                cnt = 1;
            }else {
                if(cnt == 1){
                    nums[idx++] = nums[i];
                    cnt++;
                }
            }
        }

        return idx;
    }
}
