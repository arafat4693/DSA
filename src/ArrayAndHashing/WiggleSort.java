package ArrayAndHashing;

public class WiggleSort {
    public void wiggleSort(int[] nums) {

        // Arrays.sort(nums);
        // for(int i = 1; i < nums.length-1; i += 2){
        //     int tmp = nums[i];
        //     nums[i] = nums[i+1];
        //     nums[i+1] = tmp;
        // }

        for(int i = 1; i < nums.length; i += 2){
            int prev = nums[i-1];
            int next = i+1 == nums.length ? 0 : nums[i+1];

            if(nums[i] < prev){
                nums[i-1] = nums[i];
                nums[i] = prev;
            }

            if(nums[i] < next){
                nums[i+1] = nums[i];
                nums[i] = next;
            }
        }
    }
}
