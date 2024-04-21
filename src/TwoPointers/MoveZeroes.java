package TwoPointers;

public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        // for(int i = 1; i < nums.length; i++){
        //     if(nums[i] != 0){
        //         int tmp = nums[i], j = i;
        //         while(j > 0 && nums[j-1] == 0){
        //             nums[j-1] = tmp;
        //             nums[j--] = 0;
        //         }
        //     }
        // }

        int j = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                nums[j] = nums[i];
                if(j != i) nums[i] = 0;
                j++;
            }
        }
    }
}
